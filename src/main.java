import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] arguments) throws IOException
	{
		ipScanner ip = new ipScanner();
	  	Scanner s = new Scanner (System.in);
	  	System.out.println("Ingresar ip/mascara:");
	  	String input = s.next ();
	  	ip.fAnalizarEntrtada (input);
	  	System.out.println(ip.GenerateReport());
  	}

}
