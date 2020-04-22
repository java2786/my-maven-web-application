package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			System.out.println("valid user for login page");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("name: "+session.getAttribute("name"));
			System.out.println("go to welcome");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		if(email.equals("admin@gmail.com") && pwd.equals("admin")) {
			System.out.println("valid user");
			/*
			request.getSession();		// create if session is null
			request.getSession(true);	// every time new session
			request.getSession(false);	// dont create session
			*/
			
			HttpSession session = request.getSession(true);
			session.setAttribute("name", "Admin");
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome");
			rd.forward(request, response);
		} else {
			System.out.println("invalid user");
			doGet(request, response);
		}
	}

}
