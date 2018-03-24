package com.devon.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//static int count = 0;
	@RequestMapping("/")
    public String index(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		if(session.getAttribute("count")!= null) {
			//int count = (int)session.getAttribute("count");
			session.setAttribute("count", (int) session.getAttribute("count")+1);
		}
        return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "page2.jsp";
	}
}
