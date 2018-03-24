package com.devon.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.devon.web.models.Player;

/**
 * Servlet implementation class CreatePlayer
 */
@WebServlet("/CreatePlayer")
public class CreatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	ArrayList<Object> players = new ArrayList<Object>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String team_id = (String) session.getAttribute("cur_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String age = request.getParameter("age");
		
		Player person = new Player();
		person.setTeam_id(team_id);
		person.setFirst_name(first_name);
		person.setLast_name(last_name);
		person.setAge(age);
		
		players.add(person);
		
		request.getSession();
		session.setAttribute("players", players);
		
		System.out.println(String.format("id: %s, fname: %s, lname: %s, age: %s", team_id, first_name, last_name, age));
		System.out.println(person.getId());
		response.sendRedirect("/TeamRoster/ShowTeam");
	}

}
