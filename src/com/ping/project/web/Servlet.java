package com.ping.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ping.project.common.helpers.AgentHelper;
import com.ping.project.common.helpers.ServerHelper;
import com.ping.proyect.database.PGConnector;

@SuppressWarnings("serial")
@WebServlet("/Scanner")
public class Servlet  extends HttpServlet
{
	private String result;
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		//result va a devolver todo el jar que se ejecuto


		String result = request.getParameter("result").toString();
		//ir a la base de datos a guardarlo
		//si salio todo bien 200
		
		response.setHeader(getServletName(), getServletInfo());
		
		PGConnector dbConnect = new PGConnector("10.21.37.183", "5432", "monitor_server");	
		dbConnect.connect("monitor_server", "1234");
//		dbConnect.execute("select insert_data ('" + new Gson().toJson(result).toString() + "')");
		dbConnect.execute("select insert_data ('" +result+ "')");
		dbConnect.disconnect();
		response.getWriter().println(result);
			       
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
//		
//		//cambiar aca por lo que venga de parametro del request
//
		
		result = AgentHelper.getRuntimeValue(req.getParameter("jarName"));

	}
	public static void main(String[] args) {
		ServerHelper.connect(8473, Servlet.class, "/Scanner");
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
