package com.ping.project.common;
import java.io.IOException;
import java.net.InetAddress;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ipScanner {

	 portScanner pScan = new portScanner() ;
    
    public void fAnalizarEntrtada (String input) throws IOException {
    	//10.21.37.0/24
    	String [] splitInput = input.split("/");
    	String temp= splitInput[0];
    	String [] ipSplit = temp.split("\\.");
    	String subnet = "";
    	
    	switch (Integer.parseInt(splitInput[1])){
    	case 8: 
    		System.out.println("Clase A");
    		subnet = ipSplit[0];
    		procesarMascaraA (subnet); 
    		break;
    	case 16:
    		System.out.println("Clase B");
    		subnet = ipSplit[0]+"."+ipSplit[1];
    		procesarMascaraB (subnet); 
    		break;
    	case 24:
    		System.out.println("Clase C");
    		subnet = ipSplit[0]+"."+ipSplit[1]+"."+ipSplit[2];
    		procesarMascaraC (subnet); 
    		break;
    	default: 
    		System.out.println("Default");
    		break;
    	}
    }
    
    public void procesarMascaraA(String subnet) throws IOException
    {
                
        System.out.println("Scanning...A...");
        for (int i = 1; i <= 255; i++)
        {
	        for (int j = 0; j <= 255; j++)
	        {
		        for (int k = 0; k <= 255; k++)
		        {
		        	if ((i==0 && j==0 && k==0) || (i==255 && j==255 && k==255)){
			            String host = subnet + "." + i + "." + j  + "." + k;
			            revisarHosts (host);
		        	}
		        }
	        }
        }
        System.out.println("FIN");
    }
	
	public void procesarMascaraB(String subnet) throws IOException
    {
                
        System.out.println("Scanning...B...");
        for (int i = 1; i <= 255; i++)
        {
	        for (int j = 0; j <= 255; j++)
	        {
	        	if ((i==0 && j==0) || (i==255 && j==255)){
		            String host = subnet + "." + i + "." + j;
		            revisarHosts (host);
	        	}
	        }
        }
        System.out.println("FIN");
    }
	
	public void procesarMascaraC(String subnet) throws IOException
    {
                
        System.out.println("Scanning...C...");
        for (int i = 1; i < 255; i++)
        {
            String host = subnet + "." + i;
            revisarHosts (host);
        }
        System.out.println("FIN");
    }
	
	private  void revisarHosts (String host) throws IOException {
		int timeout = 50;
		if (InetAddress.getByName(host).isReachable(timeout))
        {
            System.out.println(host + " - activa");
            pScan.fScanPort (host);
        }
		System.out.println("Scanning..." + host);
	}
	
	public String GetJson (){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(pScan.scanInfo);
	}
	
	public String GenerateReportHTML (){
		return "";
	}
	public String GenerateReport (){
		return "";
	}
}
