package es.fiturjc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fiturjc.model.User;
import es.fiturjc.service.AdminService;
import es.fiturjc.service.CourseService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CourseService courseService;

	@DeleteMapping (value="/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable long id) {
		if(adminService.deleteUser(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@PutMapping (value="/{id}")
//	public ResponseEntity<?> editUser(@PathVariable long id, @RequestBody User user ) {
//		adminService.editUser(id, user);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//	}
	
	public void addCourse() {
		
	}
	
	public void deleteCourse() {
		
	}
	
	public void editCourse() {
		
	}
	
}
