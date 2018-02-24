package es.fiturjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fiturjc.model.Course;
import es.fiturjc.repository.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository usersRepository;
	
	@RequestMapping("13")
	public String editProfile(Model model) {
		return "das";
	}
	
	@RequestMapping("31")
	public String registeredUsers() {
		return "adsds";
	}
	
	@RequestMapping("2")
	public String passwordChange() {
		return "adasda";
	}
	@RequestMapping("/{id}")
	public String registeredCourses(Model model,@PathVariable long id) throws Exception{
		List<Course> courses=usersRepository.findOne(id).getCourses();		
		model.addAttribute("courses", courses);		
		return "admin-controlActivities";
	}//if you want to show all admin's courses, in which he is a coach and in which he is a user
	
	/*@RequestMapping("/{id}")
	public String registeredCourses(Model model,@PathVariable long id) throws Exception{
		User coach=usersRepository.findByRolesAndId("Admin",id);
		List<Course> courses=coach.getCourses();		
		model.addAttribute("courses", courses);		
		return "admin-controlActivities";
	}//it only shows the courses in which he is admin*/
	
}
