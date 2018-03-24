package com.devon.web.models;

public class Cat extends Animal implements Pet{
	public String showAffection() {
		System.out.println(String.format("%s looks at you, you may pet me exactly 3 times!", this.getName()));
		return(String.format("%s looks at you, you may pet me exactly 3 times!", this.getName()));
	}
}
