package fiturjc.user;

import java.security.Principal;
import java.text.ParseException;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD:src/main/java/fiturjcl/user/UserController.java
import fiturjcl.controller.UserService;
import fiturjcl.course.Category;
import fiturjcl.course.CourseRepository;

import org.springframework.ui.Model;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
=======
import fiturjc.course.Category;
import fiturjc.course.CourseRepository;
import fiturjc.service.UserService;
>>>>>>> 6477cd8f4c70f77682084d4cbb095401355799a8:src/main/java/fiturjc/user/UserController.java

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/{nickname}")
	public String userProfile(Model model, @PathVariable String nickname) {
		if (userComponent.isLoggedUser()) {
			User userLogged = userRepository.findByNickname(userComponent.getLoggedUser().getNickname());
			User userPage = userRepository.findByNickname(nickname);
			if (userLogged == userPage) { // If an user tries to enter another user page. Counts will be given the categories 
				Map<Category, Long> counts = userPage.getCourses().stream().map(course -> course.getCategory()).collect(Collectors.groupingBy(category -> category, Collectors.counting()));
				model.addAttribute("userPage", userPage);
				model.addAttribute("counts", counts);
				return "user";
			}
		}
		return "redirect:/403.html";
	}

	@RequestMapping("/")
	public String userRedirectToProfile(Principal p) {

		if (p == null || p.getName().isEmpty())
			throw new AuthorizationServiceException("Al carrer al carrer y al carrer");

		User u = userRepository.findByEmail(p.getName());

		if (u == null) {
			throw new IllegalArgumentException("User not found");
		}

		return "redirect:/user/" + u.getNickname();
	}

	/*@RequestMapping("/newUser")
	public String newUser(Model model, User user, @RequestParam String password) throws ParseException {
		userService.createNewUser(user, password);
		return "redirect:/user/{nickname}";
	}
<<<<<<< HEAD:src/main/java/fiturjcl/user/UserController.java
	*/
=======
	
	@PostMapping (value="/imageUpload")
	public String imgUpload(@RequestParam MultipartFile file) {
		User u = userComponent.getLoggedUser(); // The user itself 
		userService.setImage(u,file);
		return "redirect:/user/" + u.getNickname() ;
	}

>>>>>>> 6477cd8f4c70f77682084d4cbb095401355799a8:src/main/java/fiturjc/user/UserController.java
}
