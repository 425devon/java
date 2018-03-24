package com.devon.web.models;

public class Player {
	private String first_name;
	private String last_name;
	private String age;
	private String team_id;
	static int id = 0;
	public int count = 0;
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAge() {
		return age;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		Player.id = id;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public Player() {
		id++;
		count++;
		this.setId(id);
	}
}
