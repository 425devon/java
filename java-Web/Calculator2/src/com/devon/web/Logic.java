package com.devon.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logic
 */

@WebServlet({ "/Logic", "/" })
public class Logic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/home.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	ArrayList<Integer> results = new ArrayList<Integer>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("perform");
		System.out.println(request.getParameter("perform"));
		Calc curCalc = new Calc();
		
		if(operation.contains("+")) {
			curCalc.addition(operation);
		}
		if(operation.contains("-")) {
			curCalc.subtraction(operation);
		}
		if(operation.contains("x")) {
			curCalc.multiplication(operation);
		}
		if(operation.contains("/")) {
			curCalc.division(operation);
		}
		
		System.out.println(curCalc.getResult());
		results.add(curCalc.getResult());
		session.setAttribute("results", results);
		
		response.sendRedirect("/Calculator2/");
	}

}
