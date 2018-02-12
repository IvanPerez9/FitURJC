package FitURJC.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping (value = "/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private UserComponent userComponent;
	
	@RequestMapping (value = "/{nickname}")
	public String userProfile(Model model, @PathVariable String nickname, HttpServletRequest request) {
		
		User user = userRepository.findByNickname(nickname);
		model.addAttribute("userPage",user);
		return "user";
	}
}
