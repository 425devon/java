package com.devon.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	
    @RequestMapping(path="/submit", method=RequestMethod.POST)
    public String sub(@RequestParam(required=(false), value="name") String name,
    					@RequestParam(required=(false), value="location") String location,
    					@RequestParam(required=(false), value="language") String language,
    					@RequestParam(required=(false), value="comment") String comment
    					) {
        return "display.jsp";
    }

}