package FitURJC.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import FitURJC.User.User;

import java.security.Principal;
import java.text.SimpleDateFormat;

public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("loginerror", true);
		return "login";
	}
	
	
	

	
}