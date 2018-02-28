package es.fiturjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("loginerror", true);
		return "loginerror";
	}

	
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}

}