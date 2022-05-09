package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		
		
		FacebookServiceInterface fs=new FacebookService();
		
		int i=fs.loginProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
			HttpSession hs=request.getSession(true);
			
			
			hs.setAttribute("myid", name);
			
			out.println("Welcome  "+name);
			out.println("<br>View Profile <a href=ViewProfileServlet>View Profile</a> ");
			
		}
		out.println("</body></html>");
	}


}










