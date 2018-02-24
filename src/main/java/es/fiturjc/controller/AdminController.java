package es.fiturjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/editProfile/{nickname}",method=RequestMethod.PUT)
	public String editProfile(@PathVariable String nickname,@RequestBody MultiValueMap<String,String> params) {
		userService.editUser(usersRepository.findByNickname(nickname), params);
		return "admin";
	}
	
	@RequestMapping(value="/{nickname}/users", method=RequestMethod.GET)
	public String registeredUsers(Model model, @PathVariable String nickname) throws Exception{
		User user=usersRepository.findByNickname(nickname);
		if(user.getRoles().contains("Admin")) {
			List<User> users=usersRepository.findAll();
			users.remove(user);
			model.addAttribute("users",users);
		}		
		return "admin-controlUsers";
	}
	
	@RequestMapping(value="{nickname}/changePass",method=RequestMethod.PUT)
	public String passwordChange(@PathVariable String nickname,@RequestBody User user) {
		userService.updateUserInfo(nickname, user);
		return "admin-passwordChange";
	}
	
	@RequestMapping(value="/{nickname}/courses", method=RequestMethod.GET)
	public String registeredCourses(Model model,@PathVariable String nickname) throws Exception{
		User user=usersRepository.findByNickname(nickname);
		if(user.getRoles().contains("Admin")) {
			List<Course> courses=user.getCourses();		
			model.addAttribute("courses", courses);	
		}
		return "admin-controlActivities";
	}

}

