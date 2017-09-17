package com.ping.project.console;
import java.util.Scanner;
import com.ping.project.common.scanners.IPScanner;
import com.ping.project.common.Reports;
import com.ping.project.common.entities.IPInfo;

public class Main
{
	private static Scanner s;

	public static void main(String[] args) throws Exception
    {
		IPInfo ipInfo = new IPInfo();
	  	s = new Scanner (System.in);
	  	System.out.println("Ingresar ip/mascara:");
	  	String input = s.next ();
        IPScanner ip = new IPScanner(ipInfo, true);
	  	ip.fAnalizarEntrada(input);
	  	System.out.println(new Reports(ipInfo).GenerateReport());
    }
}