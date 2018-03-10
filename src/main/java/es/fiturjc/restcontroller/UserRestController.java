package es.fiturjc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.User;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	/**
	 * Simple getUser by nickname
	 * @param nickname
	 * @return user 
	 */
	
	@RequestMapping(value = "/{nickname}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String nickname) {
		User user = userService.getUser(nickname);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Checks if the user is logged the it update user info using the service . MIRAR OJO 
	 * @param nickname
	 * @param user
	 * @return user
	 */
	
	@RequestMapping(value = "/edit/{nickname}", method = RequestMethod.PUT)
	public ResponseEntity<User> editUserProfile(@PathVariable String nickname, @RequestBody User user) {
		User updatedUser = userService.getUser(nickname);
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId()); 
		if (updatedUser == userLogged) {
			if (updatedUser != null) {
				updatedUser = userService.updateUserInfo(nickname, user);
				return new ResponseEntity<>(updatedUser, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Create a new user , user and pass
	 * @param user
	 * @return newUser
	 */
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createNewUser(@RequestBody User user ) {
		User newUser = userService.createNewUser(user, user.getPasswordHash());
		if (newUser != null) {
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
