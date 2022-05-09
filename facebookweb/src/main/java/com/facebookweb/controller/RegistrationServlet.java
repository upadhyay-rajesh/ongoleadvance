package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

public class RegistrationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		
		int i=fs.createProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
			out.println("Registration Successful ");
			out.println("<br>click here to continue <a href=signin.html>Click</a> ");
			
		}
		out.println("</body></html>");
	}

}









