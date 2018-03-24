package com.devon.web.models;

import java.util.ArrayList;

public class Team {
	private String team_name;
	private ArrayList<String> players;
	static int id = 0;
	
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setPlayers(ArrayList<?> players, String player) {
		this.players.add(player);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		Team.id = id;
	}
	public Team () {
		id++;
		this.setId(id);
		
	}
}
