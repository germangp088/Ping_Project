package com.ping.project.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.ping.project.common.helpers.ServerHelper;

public class Client extends AbstractHandler
{
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<form name=\"jpForm\" method=\"post\" action=\"http://localhost:8473/Scanner\">");
        response.getWriter().println("<label>Ingresar ip/mascara:</label>");
        response.getWriter().println("<input type=\"text\" name=\"ip\"/> <br/>");
        response.getWriter().println("<input type=\"submit\" value=\"Enviar\" />");
        response.getWriter().println("</form>");
    }

    public static void main(String[] args) throws Exception
    {
		ServerHelper.connect(8081, new Client());
    }
}
