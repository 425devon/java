package com.devon.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(@RequestParam(required=(false), value="first_name", defaultValue="Human") String first_name,
    					@RequestParam(required=(false), value="laast_name", defaultValue="Person") String last_name
    					) {
    	
        return "index.jsp";
    }
}