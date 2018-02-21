package fiturjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiturjc.user.User;

import java.security.Principal;
import java.text.SimpleDateFormat;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("loginerror", true);
		return "loginerror";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.GET)
		public String register() {
			return "register";
		}
	

}