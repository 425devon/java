package com.devon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String name = "Unkown";
		if(request.getParameter("name") != null){
			name = request.getParameter("name");
		};
		
		String lang = "Unkown";
		if(request.getParameter("lang") != null){
			lang = request.getParameter("lang");
		};
		
		String loc = "Unkown";
		if(request.getParameter("loc") != null){
			loc = request.getParameter("loc");
		};

		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Welcome, "+name+"</h1>");
        out.write("<h2>Your favorite language is: "+lang+"</h2>");
        out.write("<h2>Your hometown is: "+loc+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
