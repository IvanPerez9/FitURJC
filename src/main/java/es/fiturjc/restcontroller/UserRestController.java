package es.fiturjc.restcontroller;

import java.util.Collection;
import java.util.List;

import es.fiturjc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.User;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	interface UserDetail extends User.Basic, User.Details {
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserComponent userComponent;

	/**
	 * List of all the Users. CHECKED
	 * 
	 * @return users
	 */
	public interface UserDetails extends User.Basic, User.Details{}
	
	@GetMapping(value = "/")
	@JsonView(UserDetails.class)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@JsonView(UserDetail.class)
	@GetMapping(value = "/{id:.*}")
	public ResponseEntity<User> getSingleUser(@PathVariable String id) {
		boolean isEmail = false;
		long idd = 0;
		try {
			idd = Long.parseLong(id);
		} catch (NumberFormatException e) {
			isEmail = true;
		}
		User u = isEmail ? userService.findOne(id) : userService.findOne(idd);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

	/**
	 * Checks if the user is logged the it update user info using the service .
	 * Checks if the user is the same that its trying to edit
	 * 
	 * @param nickname
	 * @param user
	 * @return user
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<User> editUserProfile(@PathVariable long id, @RequestBody User user) {
		if (userComponent.isLoggedUser() == true) {
			User updatedUser = userService.getUserbyID(id);
			User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
			if (updatedUser == userLogged) {
				if (updatedUser != null) {
					updatedUser = userService.updateUserInfo(id, user);
					return new ResponseEntity<>(updatedUser, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@JsonView(CourseRestController.CourseDetails.class)
    @GetMapping("/recommendedCourses")
    public ResponseEntity<Collection<Course>> userProfile() {

        if(!userComponent.isLoggedUser()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User userLogged = userComponent.getLoggedUser(); // Check if the user is logged

        return new ResponseEntity<>(userService.getRecommendedCoursesForUser(userLogged), HttpStatus.OK);
    }
}
