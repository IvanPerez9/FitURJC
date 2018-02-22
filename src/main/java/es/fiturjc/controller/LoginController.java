package es.fiturjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	/**
	 * Search a template for login.
	 * 
	 * @return the html with the login form
	 */
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * Search a template for loginError and show it.
	 * 
	 * @param model
	 *            for the loginError
	 * @return the html with the login error.
	 */
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("loginerror", true);
		return "loginerror";
	}

	/**
	 * Search a template for register and show it
	 * 
	 * @return the html with the register Form.
	 */
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}

}