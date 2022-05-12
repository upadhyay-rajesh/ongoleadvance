package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailValidationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String em=request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(em.equals("rajesh@gmail.com")) {
				out.println("<font color=red>Email Already Exist</font>");
			}
			else {
				out.println("<font color=green>Valid Email</font>");
			}
		out.println("</body></html>");
		
	}

}







