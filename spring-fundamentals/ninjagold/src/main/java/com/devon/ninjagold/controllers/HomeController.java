package com.devon.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("")
    public String index(HttpSession session) {
    	if(session.getAttribute("gold") == null) {
    	int gold = 0;
    	String time = setDate();
    	session.setAttribute("alog", "Weclome to Java Gold");
    	session.setAttribute("gold", gold);
    	session.setAttribute("time", time);
    	System.out.println(session.getAttribute("time"));
    	}
        return "gold.jsp";
    }
    @RequestMapping("/farm")
    public String farm(HttpSession session) {
    	Random ran = new Random();
    	int val = ran.nextInt(20+1 - 10)+10;
    	int curgold =(int) session.getAttribute("gold") + val;
    	String curlog = (String) session.getAttribute("alog");
    	String time = setDate();
    	String newLog = curlog + String.format("\n You earned %d gold on the farm! %s", val, time);
    	session.setAttribute("gold", curgold);
    	session.setAttribute("alog", newLog);
        return "redirect:/";
    }
    @RequestMapping("/cave")
    public String cave(HttpSession session) {
    	Random ran = new Random();
    	int val = ran.nextInt(10+1 - 5)+5;
    	String time = setDate();
    	int curgold =(int) session.getAttribute("gold") + val;
    	String curlog = (String) session.getAttribute("alog");
    	String newLog = curlog + String.format("\n You found %d gold in the Cave! %s", val, time);
    	session.setAttribute("gold", curgold);
    	session.setAttribute("alog", newLog);
    	System.out.println("cave");
        return "redirect:/";
    }
    @RequestMapping("/house")
    public String house(HttpSession session) {
    	Random ran = new Random();
    	int val = ran.nextInt(5 + 1 - 2) + 2;
    	String time = setDate();
    	int curgold =(int) session.getAttribute("gold") + val;
    	String curlog = (String) session.getAttribute("alog");
    	String newLog = curlog + String.format("\n You earned %d gold in the House! %s", val, time);
    	session.setAttribute("gold", curgold);
    	session.setAttribute("alog", newLog);
    	System.out.println("house");
        return "redirect:/";
    }
    @RequestMapping("/casino")
    public String casino(HttpSession session) {
    	Random ran = new Random();
    	int val = ran.nextInt(50 + 1 + 50) -50;
    	String time = setDate();
    	int curgold =(int) session.getAttribute("gold") + val;
    	String curlog = (String) session.getAttribute("alog");
    	String newLog = curlog + String.format("\n Tried your luck at the casion, %d gold! %s", val, time);
    	session.setAttribute("gold", curgold);
    	session.setAttribute("alog", newLog);
    	System.out.println("casino");
        return "redirect:/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    public String setDate() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime localDate = LocalDateTime.now();
		return dtf.format(localDate);
    }
}
