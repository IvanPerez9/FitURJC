package es.fiturjc.restcontroller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.controller.LoginController;
import es.fiturjc.model.User;

@RestController
@RequestMapping("/api")
public class LoginRestController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserComponent userComponent;
	
	interface UserDetail extends User.Basic,User.Details{
	}
	
	@JsonView(UserDetail.class)
	@RequestMapping("/logIn")
	public ResponseEntity<User> logIn(Principal principal){
		if(!userComponent.isLoggedUser()){
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			 User loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getNickname());
			return new ResponseEntity<>(loggedUser,HttpStatus.OK);
		}
	}

	@JsonView(UserDetail.class)
	@RequestMapping("/logOut")
	public ResponseEntity<Boolean> logOut(HttpSession session){
		if(!userComponent.isLoggedUser()){
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}else{
			session.invalidate();
			log.info("Logged out");
			return new ResponseEntity<>(true,HttpStatus.OK);
		}
	}
	
}
