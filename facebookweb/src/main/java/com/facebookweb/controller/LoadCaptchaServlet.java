package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadCaptchaServlet
 */
public class LoadCaptchaServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int i=(int)(Math.random()*10000);
		String ss="md$&hddf#";

		out.println("<html><body>");

		out.println("<input type=text disabled  value="+i+"><input type=hidden id=c1 value="+i+"><input type=button value=refresh onclick=loadCaptcha()>");
		out.println("Enter above value <input type=text id=c2><input type=button value=validate onclick=validateCapcha()>");
		out.println("</body></html>");

	}
}











