package fiturjcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fiturjcl.user.User;
import fiturjcl.user.UserRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/profileSettings")
public class ProfileSettingsController {
	
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private UserComponent userComponent;
	
	@RequestMapping(value = "/{id}")
    public String userProfile(Model model, @PathVariable long id, HttpServletRequest request) {
        User userSettings = userRepository.findOne(id);
        model.addAttribute("userPage", userSettings); // La var que uso para el
                                                        // acceso a datos

        return "profile_settings"; // El del template
    }
	
	@RequestMapping(value = "/edit")
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
