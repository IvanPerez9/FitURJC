package FitURJC.ProfileSettings;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import FitURJC.User.User;
import FitURJC.User.UserRepository;

import org.springframework.ui.Model;

@Controller
public class ProfileSettingsController {
	
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private UserComponent userComponent;
	
	@RequestMapping ("/profileSettings")
	public String userProfile(Model model, HttpServletRequest request) {
		
		long variable = 1;
		User userSettings = userRepository.findOne(variable);
		model.addAttribute("userPage",userSettings); // La var que uso para el acceso a datos
		
		
		return "profile_settings"; // El del template
	}
	
	@RequestMapping("/profileSettings/edit")
    public String userProfileEdit(Model model, @PathVariable long id, @RequestParam String name,@RequestParam String surname, @RequestParam String email, @RequestParam String passwordHash, @RequestParam int age)
           {

        User editedUser = userRepository.findOne(id);
        //User me = userService.findOne(userComponent.getLoggedUser().getId());


            editedUser.setName(name);
            editedUser.setSurname(surname);
            editedUser.setEmail(email);
            editedUser.setAge(age);
            // Falta pass
            
            userRepository.save(editedUser);

        return "redirect:/user/{nickname}";
    }
}
