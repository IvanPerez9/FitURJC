package es.fiturjc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.service.CourseService;


@Controller
public class MainController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserComponent userComponent;


	@RequestMapping(value = "/")
	public String getIndex(Model model, HttpServletRequest request) {
		Page<Course> coursesIndex = courseService.getPageCourses();
		model.addAttribute("courses", coursesIndex);
		// New
		// Check if a user is logged
		if ((userComponent.isLoggedUser())) {
			long userLogged_id = userComponent.getLoggedUser().getId();
			User userLogged = userRepository.findOne(userLogged_id);
			model.addAttribute("user", userLogged);
			if (userComponent.getLoggedUser().getId() == userLogged.getId()) {
				model.addAttribute("logged", true);
			}
			// Check if is an Admin
			model.addAttribute("admin", request.isUserInRole("ROLE_ADMIN"));
			return "index";
		} else {
			return "index";
		}
	}

}
