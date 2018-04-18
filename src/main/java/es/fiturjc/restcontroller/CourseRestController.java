package es.fiturjc.restcontroller;

import java.util.List;

import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.Schedule;
import es.fiturjc.model.User;
import es.fiturjc.service.CourseService;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/course")
public class CourseRestController {
	
	interface CourseDetail extends Course.Basic,Course.Details , Schedule.Basic,Schedule.Details{
	}
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;


	/**
	 *
	 * @return
	 */
	
	public interface CourseDetails extends Course.Basic, Course.Details, Schedule.Basic, Schedule.Details,User.Basic{}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@JsonView(CourseDetails.class)
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
	 * @param page
	 * @return
	 */
	//Pagination
	@RequestMapping(value = "/paginate/{page}", method = RequestMethod.GET)
	public Page<Course> getAllCourses(@PathVariable("page") int page) {
		return courseService.findAllCourses(new PageRequest(page, 10));
	}



	/**
	 * Get 1 course
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@JsonView(CourseDetail.class)
	public ResponseEntity<Course> getCourseId(@PathVariable long id) {
		Course course = courseService.findCourse(id);
		if (course != null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Create new Course
	 * @param course
	 * @return new course
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if (userLogged != null) {
			courseService.save(course);
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	/**
	 * EditTest VERIFICAR 
	 * @param id
	 * @param editCourse
	 * @return
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Course> editCourse(@PathVariable long id, @RequestBody Course editCourse) {
		Course course = courseService.findCourse(id);
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if (userLogged != null) {
			if (course != null && editCourse != null) {
				editCourse.setId(id);
				courseService.save(editCourse);
				return new ResponseEntity<>(editCourse, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}
	
	/**
	 * Simple delete courses 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Course> deleteCourse(@PathVariable long id) {
		courseService.deleteCourse(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Add new Schedule 
	 * @param id
	 * @param schedule
	 * @return
	 */
	
//	@RequestMapping(value = "/{id}/schedule", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Schedule> addSchedule(@PathVariable long id, @RequestBody Schedule schedule) {
//
//		Course course = courseService.findCourse(id);
//		
//		
//
//	}
	
	// MOVER LOGICA DEL COURSECONTROLLER PARA LOS SCHEDULES 
	
}
