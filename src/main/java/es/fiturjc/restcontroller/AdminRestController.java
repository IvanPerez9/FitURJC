package es.fiturjc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.service.AdminService;
import es.fiturjc.service.CourseService;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	// ************* USERS *****************
	
	/**
	 * Get users. checked 
	 * @return
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if (users != null) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Delete an User using the id. Checked
	 * @param id
	 * @return
	 */

	@DeleteMapping (value="/user/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteUser (@PathVariable long id) {
		if(adminService.deleteUser(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * NO SE SI ESTO ESTA BIEN 
	 * @param id
	 * @param user
	 * @return
	 */
	
//	@PutMapping (value="/user/edit/{id}")
//	public ResponseEntity<?> editUser(@PathVariable long id, @RequestBody User user ) {
//		if(adminService.editUser(id, user, user.getPasswordHash()){
//			return new ResponseEntity<>(user, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND ); 
//	}
	
	
	//****************** COURSES **************
	
	/**
	 * MIRAR PORQUE NO VA
	 * @return
	 */
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = courseService.getAllCourses();
		if (courses != null) {
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 
	 * @param course
	 * @return new course
	 */
	
	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if (userLogged != null) {
			courseService.createNewCourse(course, null); 
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Delete user by id
	 * @param id
	 * @return
	 */
	
	@DeleteMapping(value="/course/delete/{id}") 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteCourse(@PathVariable long id) { 
		if(courseService.deleteCourse(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Edit course by id 
	 * @param id
	 * @param course
	 * @return course
	 */
	
	@PutMapping (value="/course/edit/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> editCourse(@PathVariable long id , @RequestBody Course course) { 
		Course c = courseService.findCourse(id);
		if(c != null) {
			courseService.editCourse(course, id);
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
