package net.project.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.project.springboot.model.Employee;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	/*
	 * @GetMapping("/") public String home() { return "index"; }
	 */
	
	
	  @PostMapping("/login") public String logintoIndex() {
	  
	  return "redirect:/viewemployee"; }
	 
}
