package es.fiturjc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.service.CourseService;
import es.fiturjc.service.UserService;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;

	// @Autowired
	// private UserComponent userComponent;

	@RequestMapping(value = "")
	public String getCourses(Model model, Principal principal) {
		boolean isLogged = principal != null;
		User visitor = (isLogged) ? userService.findByEmail(principal.getName()) : null;
		List<Course> courses = courseService.getAllCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("visitor", visitor);
		return "courses";
	}

	// @RequestMapping (value = "/")
	// public String userProfile (Model model, HttpServletRequest request) {
	//
	// return "courses";
	// }

	//
	// @RequestMapping (value = "/moreCourses")
	// public String moreAllShelf(Model model, @RequestParam int page) {
	// Page<Course> courses = courseRepository.findAll(new PageRequest(page,6));
	// model.addAttribute("course", courses);
	// return "list_courses";
	// }

}
