package com.devon.web.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.devon.web.models.Team;

/**
 * Servlet implementation class CreateTeam
 */
@WebServlet("/CreateTeam")
public class CreateTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//team name and id
	HashMap<Integer, String> team_list = new HashMap<Integer, String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String team_name = request.getParameter("team_name");
		Team team = new Team();
		team.setTeam_name(team_name);
		
		System.out.println(team.getTeam_name());
		System.out.println(team.getId());
		
		team_list.put(team.getId(), team.getTeam_name());
		
		HttpSession session = request.getSession();
		session.setAttribute("teams", team_list);
		
		response.sendRedirect("/TeamRoster/ShowRoster");
	}

}
