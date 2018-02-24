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
	
	@RequestMapping("")
	public String editProfile(Model model) {
		return "admin";
	}
	
	@RequestMapping("")
	public String registeredUsers() {
		return "admin-controlUsers";
	}
	
	@RequestMapping("")
	public String passwordChange() {
		return "admin-passwordChange";
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
