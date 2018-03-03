package es.fiturjc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import es.fiturjc.model.Category;
import es.fiturjc.model.Schedule;
import es.fiturjc.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.repository.CourseRepository;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserRepository usersRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@RequestMapping("/adminPage")
	public String adminRoot(Model model) {
		model.addAttribute("editSection", true);
		return "admin";
	}

	@RequestMapping("/adminPage/manageUsers")
	public String manageUsers(Model model, String action) {
		model.addAttribute("manageUsersSection", true);
		List<User> users = usersRepository.findAll();
		model.addAttribute("users", users);
		return "admin";
	}

	@RequestMapping("/adminPage/manageUsers/delete/{id}")
	public String manageUsersDelete(@PathVariable long id) {
		User user = usersRepository.findOne(id);
		usersRepository.delete(user);
		return "redirect:/adminPage/manageUsers";
	}

	@RequestMapping("/adminPage/manageCourses")
	public String manageGroups(Model model, String action) {
		model.addAttribute("manageCoursesSection", true); // For the template
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses", courses);
		return "admin";
	}

	@RequestMapping("/adminPage/manageCourses/delete/{id}")
	public String manageGroupsDelete(@PathVariable long id) {
		Course course = courseRepository.findOne(id);
		courseRepository.delete(course);
		return "redirect:/adminPage/manageCourses";
	}

	// For future graphics

	@RequestMapping("/adminPage/graphics")
	public String graphics(Model model, String action) {
		model.addAttribute("graphicsSection", true);
		return "admin";
	}

	// From Denise

	@RequestMapping(value = "/editProfile/{nickname}", method = RequestMethod.PUT)
	public String editProfile(@PathVariable String nickname, @RequestBody Map<String, String> params) {
		userService.editUser(usersRepository.findByNickname(nickname), params);
		return "admin";
	}

	@RequestMapping(value = "/{nickname}/users", method = RequestMethod.GET)
	public String registeredUsers(Model model, @PathVariable String nickname) {
		User user = usersRepository.findByNickname(nickname);
		if (user.getRoles().contains("Admin")) {
			List<User> users = usersRepository.findAll();
			users.remove(user);
			model.addAttribute("users", users);
		}
		return "admin-controlUsers";
	}

	@RequestMapping(value = "{nickname}/changePass", method = RequestMethod.PUT)
	public String passwordChange(@PathVariable String nickname, @RequestBody User user) {
		userService.updateUserInfo(nickname, user);
		return "admin-passwordChange";
	}

	@RequestMapping("/adminPage/manageCourses/addCourse")
	public String addCourset(Model model) {
		model.addAttribute("addCourse", true);
		EnumSet<Category> categories = EnumSet.allOf(Category.class);
		model.addAttribute("categories", categories);
		return "addCourse";
	}

	@PostMapping("/adminPage/manageCourses/addCourse")
	public String registerCourse(@RequestParam String name, @RequestParam Category category,
			@RequestParam String description, @RequestParam MultipartFile file, @RequestParam String schedules) {
		String[] schedule = schedules.split(" ");
		List<Schedule> listSchedule = new ArrayList<Schedule>();
		for (String item : schedule) {
			Schedule subSchedule = new Schedule(item);
			listSchedule.add(subSchedule);
		}

		courseService.createNewCourse(name, category, description, file, listSchedule);
		return "redirect:/adminPage/manageCourses";
	}
}
