package com.ping.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.project.common.scanners.IPScanner;
import com.ping.project.common.entities.Configuration;
import com.ping.project.common.entities.IPInfo;
import com.ping.project.common.factories.ReportsFactory;
import com.ping.project.common.helpers.ServerHelper;

@SuppressWarnings("serial")
@WebServlet("/Scanner")
public class Servlet  extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		Configuration configuration = new Configuration(Integer.parseInt(request.getParameter("lowPort")) ,
				Integer.parseInt(request.getParameter("highPort")));
		IPInfo ipInfo = new IPInfo();
        String ip = request.getParameter("ip");
        
        IPScanner ipScanner = new IPScanner(ipInfo, false, configuration);
        ipScanner.fAnalizarEntrada(ip);
        response.getWriter().println(new ReportsFactory(ipInfo, true).GenerateReport());
    }
	
	public static void main(String[] args) {
		ServerHelper.connect(8473, Servlet.class, "/Scanner");
	}
}
