package es.fiturjc.controller;

import javax.servlet.http.HttpServletRequest;

import es.fiturjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.service.CourseService;

import java.security.Principal;


@Controller
public class MainController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserComponent userComponent;


	@RequestMapping(value = "/")
	public String getIndex(Model model, HttpServletRequest request, Principal p) {
		Page<Course> coursesIndex = courseService.getPageCourses();
		model.addAttribute("courses", coursesIndex);

		if (p != null) {
			User userLogged = userRepository.findByEmail(p.getName());
            userComponent.setLoggedUser(userLogged);
            model.addAttribute("logged", true);

            if (!userService.isUserFull(userLogged))
                throw new UserNotFullException();
			model.addAttribute("user", userLogged);
			// Check if is an Admin
			model.addAttribute("admin", request.isUserInRole("ROLE_ADMIN"));
			return "index";
		} else {
			return "index";
		}
	}

}
