package com.ping.project.console;
import java.util.Scanner;
import com.ping.project.common.ipScanner;

public class main
{

    private static Scanner s;

	public static void main(String[] args) throws Exception
    {
	  	s = new Scanner (System.in);
	  	System.out.println("Ingresar ip/mascara:");
	  	String input = s.next ();
        ipScanner ip = new ipScanner();
	  	ip.fAnalizarEntrtada (input);
	  	System.out.println(ip.GenerateReport());
    }
}