import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class portScanner {
	private Scanner sc;
	public ArrayList <ipInfo> scanInfo = new ArrayList<ipInfo>();
	
	public void fScanPort (String ip){
		scan (ip, 0, 65535, 300);
	}

	private final void scan(String ipAddress, int lowPort, int highPort, int timeout ) {
		ipInfo scan = new ipInfo();
		scan.ip = ipAddress;
		
		if (!validPort(lowPort) || !validPort(highPort)) {
			System.out.println("El rango de los puertos debe ser de 0 a 65535" + System.lineSeparator() );
			return;
		}
		
		if(highPort <= lowPort ) {
			System.out.println("El puerto mayor debe ser un valor mayor al menor." + System.lineSeparator() );
			return;
		}
		System.out.println("Scanning...");
		for( int current = lowPort; current <= highPort; current++ ) {
			try {
				Socket s = new Socket();
				s.connect( new InetSocketAddress( ipAddress, current ), timeout ); //attempt a connection
				s.close();
				
				System.out.println("Open port: " + current + System.lineSeparator() );
				scan.ports.add(String.valueOf(current));
				
			}
			catch( IOException ioe ) {

			}
		}
		scanInfo.add(scan);
	}
	
	private boolean validPort(int port)
	{
		return (port > 0 || port <= 65535);
	}
}
