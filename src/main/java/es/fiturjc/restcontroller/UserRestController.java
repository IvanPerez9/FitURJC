package es.fiturjc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.User;
import es.fiturjc.restcontroller.LoginRestController.UserDetail;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	interface UserDetail extends User.Basic,User.Details{
	}
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	/**
	 * List of all the Users. CHECKED 
	 * @return users 
	 */
	@GetMapping(value = "/")
	@JsonView(User.Basic.class)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Simple getUser by nickname
	 * @param id
	 * @return user 
	 */
	@JsonView(UserDetail.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User user = userService.getUserbyID(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	/**
//	 * Simple getUser by nickname
//	 * @param nickname
//	 * @return user 
//	 */
//	@JsonView(UserDetail.class)
//	@RequestMapping(value = "/{nickname}", method = RequestMethod.GET)
//	public ResponseEntity<User> getUser(@RequestParam(value="nickname") String nickname) {
//		User user = userService.getUser(nickname);
//		if (user != null) {
//			return new ResponseEntity<>(user, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
	
	/**
	 * Checks if the user is logged the it update user info using the service . MIRAR OJO 
	 * @param nickname
	 * @param user
	 * @return user
	 */
	
	@RequestMapping(value = "/{nickname}", method = RequestMethod.PATCH)
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
	 * Create a new user , user and pass. CHECKED
	 * @param user
	 * @return newUser
	 */
	
	@JsonView(UserDetail.class)
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
