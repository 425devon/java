package com.devon.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devon.web.models.Cat;

/**
 * Servlet implementation class ShowCat
 */
@WebServlet("/ShowCat")
public class ShowCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		String weight = request.getParameter("weight");
		
		System.out.println(String.format("name: %s, breed: %s, weight: %s", name, breed, weight));
		
		Cat cat = new Cat();
		cat.setName(name);
		cat.setBreed(breed);
		cat.setWeight(weight);
		
		request.setAttribute("cat", cat);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/showCat.jsp");
		view.forward(request, response);

		//doGet(request, response);
	}

}
