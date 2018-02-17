package FitURJC.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping (value = "/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@RequestMapping ("/{nickname}")
	public String userProfile(Model model, @PathVariable String nickname) {
		
		User user = userRepository.findByNickname(nickname);
		model.addAttribute("userPage",user);
		return "user";
	}

	@RequestMapping("/")
	public String userRedirectToProfile(Principal p){

		if(p == null || p.getName().isEmpty())
			throw new AuthorizationServiceException("Al carrer al carrer y al carrer");

		User u = userRepository.findByEmail(p.getName());

		if(u == null){
		    throw new IllegalArgumentException("User not found");
        }

        return "redirect:/user/" + u.getNickname();
	}
	
	@RequestMapping("/newUser")
	public String newUser(Model model, User user, @RequestParam String password) throws ParseException {
		userService.createNewUser(user, password);
		return "redirect:/user/{nickname}";
	}
	
}
