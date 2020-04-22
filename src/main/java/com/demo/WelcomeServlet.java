package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in welcome page, verify if user is logged in");
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("name")!=null) {
			System.out.println("valid user for welcome page");
			System.out.println("name: "+session.getAttribute("name"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("login in first");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
