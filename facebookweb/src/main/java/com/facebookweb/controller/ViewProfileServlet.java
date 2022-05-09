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

/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(true);
		String n=hs.getAttribute("myid").toString();
		
		FacebookUser fb=new FacebookUser();
		fb.setName(n);
				
		FacebookServiceInterface fs=new FacebookService();
		
		FacebookUser i=fs.viewProfileService(fb);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i!=null) {
			out.println("Name is  "+i.getName());
			out.println("<br>email is  "+i.getEmail());
			
		}
		out.println("</body></html>");
	}

}







