package es.fiturjc.controller;

import java.security.Principal;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Category;
import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserComponent userComponent;

	@RequestMapping("/{nickname}")
	public String userProfile(Model model, @PathVariable String nickname) {
		if (userComponent.isLoggedUser()) {
			User userLogged = userRepository.findByNickname(userComponent.getLoggedUser().getNickname());
			User userPage = userRepository.findByNickname(nickname);
			if (userLogged == userPage) { // If an user tries to enter another user page. Counts will be given the
											// categories
				Map<Category, Long> counts = userPage.getCourses().stream().map(course -> course.getCategory())
						.collect(Collectors.groupingBy(category -> category, Collectors.counting()));
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

	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/ACIONNNN")
	public String registerUser(@RequestParam String nameUser) {
		//userService.createNewUser(user, pass);
		return null;
	}

	@RequestMapping("/newUser")
	public String newUser(Model model, User user, @RequestParam String password) {
		userService.createNewUser(user, password);
		return "redirect:/user/{nickname}";
	}

	@PostMapping("/imageUpload")
	public String imgUpload(@RequestParam MultipartFile file) {
		User u = userComponent.getLoggedUser(); // The user itself
		userService.setImage(u, file);
		return "redirect:/user/" + u.getNickname();
	}

	/**
	 * View for the edit user Form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editUser")
	public String userProfile(Model model) {
		User userSettings = userComponent.getLoggedUser();
		model.addAttribute("userPage", userSettings); // Variable that i use // Data access
		return "profile_settings";
	}

	/**
	 * Controller for the edited user.
	 * 
	 * @param model
	 * @param id
	 * @param name
	 * @param surname
	 * @param email
	 * @param passwordHash
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/editedUser")
	public String userProfileEdit(@RequestParam MultiValueMap<String, String> params) {
		User editedUser = userComponent.getLoggedUser();
		userService.editUser(editedUser, params);

		return "redirect:/user/editUser";
	}

}
