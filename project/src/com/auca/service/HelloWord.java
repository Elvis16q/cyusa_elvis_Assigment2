package com.auca.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signUp")
public class HelloWord extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
	
		 String username = req.getParameter("name");
	        String password = req.getParameter("password");

	        if ("cyusa elvis".equals(username) && "player11".equals(password)) {
	            try {
	            	HttpSession session = req.getSession(true);
	            	session.setAttribute("name", username);
	                res.sendRedirect("StudentAdmission.html");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {            
	            res.sendRedirect("forgetPassword.html"); 
	        }
	
	
	
	
	
	}
}
