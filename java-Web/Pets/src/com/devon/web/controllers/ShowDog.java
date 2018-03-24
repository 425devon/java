package com.devon.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devon.web.models.Dog;

/**
 * Servlet implementation class ShowDog
 */
@WebServlet("/ShowDog")
public class ShowDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				
				Dog dog = new Dog();
				dog.setName(name);
				dog.setBreed(breed);
				dog.setWeight(weight);
				
				request.setAttribute("dog", dog);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/showDog.jsp");
				view.forward(request, response);

				//doGet(request, response);
	}

}
