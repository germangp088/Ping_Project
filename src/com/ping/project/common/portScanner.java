package com.ping.project.common;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.ping.project.common.entities.Configuration;
import com.ping.project.common.entities.Host;
import com.ping.project.common.entities.IPInfo;

public class PortScanner {
	
	private Configuration configuration = new Configuration();
	
	public void scan(Host host, boolean _console) {
		IPInfo scan = new IPInfo();
		scan.ip = host.hostName;
		if (_console) {
			System.out.println("Scanning...");
		}
		for( int current = configuration.lowPort; current <= configuration.highPort; current++ ) {
			try {
				Socket s = new Socket();
				s.connect( new InetSocketAddress( host.hostName, current ), configuration.timeout );
				s.close();
				host.ports.add(String.valueOf(current));
			}
			catch( IOException ioe ) {

			}
		}
	}
}
