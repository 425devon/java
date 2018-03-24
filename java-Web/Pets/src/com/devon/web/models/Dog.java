package com.devon.web.models;

public class Dog extends Animal implements Pet{
	public String showAffection(){
		String res = "Sooo much love!~";
		return res;
	}
	
	public String showAffection(String weight){
		if(Integer.parseInt(weight)< 30) {
		return(String.format("%s is feelin the love!", this.getName()));
		}
		return(String.format("%s is happy and does not want to eat you!", this.getName()));
	}

}
