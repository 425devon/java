package com.devon.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devon.web.models.Player;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ArrayList<Player> players = (ArrayList<Player>) request.getSession(false).getAttribute("players");
		System.out.println(players.size());
		System.out.println(id);
		if(request.getParameter("id") != null) {
			for(int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				if(player.getId() == Integer.parseInt(request.getParameter("id"))) {
					players.remove(i);
					player.setCount(player.getCount()-1);
				}
			}
		}
		response.sendRedirect("/TeamRoster/ShowTeam");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
