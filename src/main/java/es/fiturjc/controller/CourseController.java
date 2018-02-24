package es.fiturjc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.fiturjc.component.UserComponent;
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
	@Autowired
	private UserComponent userComponent;

	@RequestMapping(value = "")
	public String getCourses(Model model, Principal principal) {
		boolean isLogged = principal != null;
		User visitor = (isLogged) ? userService.findByEmail(principal.getName()) : null;
		List<Course> courses = courseService.getAllCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("visitor", visitor);
		return "courses";
	}

	@PostMapping("/{id}/add")
	public String addCourse(Model model, @PathVariable long id, @RequestParam String idSchedule) {
		Course course = courseService.findCourse(id);
		System.out.println(idSchedule);
		User user =  userComponent.getLoggedUser();
		userService.addCourse(user,course);
		return "redirect:/courses";
	}
	
}
