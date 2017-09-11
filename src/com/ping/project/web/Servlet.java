package com.ping.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ping.project.common.ipScanner;
import com.ping.project.common.helpers.ServerHelper;


@SuppressWarnings("serial")
@WebServlet("/Scanner")
public class Servlet  extends HttpServlet
{
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String ip = request.getParameter("ip");
        ipScanner ipScanner = new ipScanner();
        ipScanner.fAnalizarEntrtada(ip);
        response.getWriter().println(ipScanner.GetJson());
    }
	
	public static void main(String[] args) {
		ServerHelper.connect(8473, Servlet.class, "/Scanner");
	}
}
