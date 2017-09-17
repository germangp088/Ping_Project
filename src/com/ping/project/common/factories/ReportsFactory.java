package com.ping.project.common.factories;

import com.ping.project.common.entities.Host;
import com.ping.project.common.entities.IPInfo;

public class ReportsFactory {
    private IPInfo _ipInfo;
	public ReportsFactory(IPInfo ipInfo)
	{
		_ipInfo = ipInfo;
	}
	
	public String GenerateReportHTML (){
		return "";
	}
	
	public String GenerateReport (){
		StringBuilder str = new StringBuilder();
		for (Host host : _ipInfo.hosts) {
			for (String port : host.ports) {
				str.append("Open port: " + port + System.lineSeparator());
			}
		}
		return str.toString();
	}
}
