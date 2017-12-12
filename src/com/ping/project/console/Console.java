package com.ping.project.console;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.ping.project.common.helpers.AgentHelper;

public class Console {

	public static void main(String[] args) throws Exception
    {
		String dir = System.getProperty("user.dir");
		File folder = new File(dir+"/Plugins");
		File[] listOfJars = folder.listFiles();
		for (File jar : listOfJars) {
			
			String result = AgentHelper.getRuntimeValue(dir+"/Plugins/"+jar.getName().toString());
			URL serverUrl = new URL("http://localhost:8473/Scanner?result="+URLEncoder.encode(result,"UTF-8"));
			HttpURLConnection urlConnection = (HttpURLConnection)serverUrl.openConnection();

			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Conten-Type", "application/json");

			BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
			httpRequestBodyWriter.write("result =" + result.toString());
			urlConnection.getInputStream();
			urlConnection.disconnect();
		}
		
    }
}
