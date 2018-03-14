package es.fiturjc.controller;

import java.util.*;

import es.fiturjc.model.Category;
import es.fiturjc.model.Schedule;
import es.fiturjc.service.AdminService;
import es.fiturjc.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	private CourseService courseService;
	
	@Autowired
	private AdminService adminService;

	@RequestMapping("/adminPage")
	public String adminRoot(Model model) {
		model.addAttribute("editSection", true);
		return "admin";
	}

	@RequestMapping("/adminPage/manageUsers")
	public String manageUsers(Model model, Pageable page) {
		Page<User> users = usersRepository.findAll(page);
		model.addAttribute("manageUsersSection", true);
		model.addAttribute("users", users);
		model.addAttribute("showNext", !users.isLast());
		model.addAttribute("showPrev", !users.isFirst());
		model.addAttribute("numPage", users.getNumber());
		model.addAttribute("nextPage", users.getNumber() + 1);
		model.addAttribute("prevPage", users.getNumber() - 1);
		return "admin";
	}

	@RequestMapping("/adminPage/manageUsers/delete/{id}")
	public String manageUsersDelete(@PathVariable long id) throws InterruptedException {
		User user = usersRepository.findOne(id);
		usersRepository.delete(user);
		Thread.sleep(3000);
		return "redirect:/adminPage/manageUsers";
	}
	
	// Edit user 
	
	@RequestMapping("/adminPage/manageUsers/edit/{id}")
	public String editSingleUser (Model model, @PathVariable long id) {
		User u = usersRepository.findById(id);
		model.addAttribute("usersEdit",u);
		
		return "admin";
	}
	
	@RequestMapping("/adminPage/editandsave/{id}")
	public String editAndSave (Model model, User user, @PathVariable long id,@RequestParam String passwordHash) throws InterruptedException{
		
		try {
			adminService.editUser(id, user,passwordHash);
		} catch (Exception e) {
			return "404.html";
		}
		
//        List<String> roles = new ArrayList<String>();
//        roles.add("ROLE_USER");
//		user.setRoles(roles);
		Thread.sleep(3000);
		return "redirect:/adminPage/manageUsers";
	}
	
	//Courses

	@RequestMapping("/adminPage/manageCourses")
	public String manageGroups(Model model, Pageable page) {
		model.addAttribute("manageCoursesSection", true); // For the template
		Page<Course> courses = courseRepository.findAll(page);
		model.addAttribute("courses", courses);
		model.addAttribute("showNext", !courses.isLast());
		model.addAttribute("showPrev", !courses.isFirst());
		model.addAttribute("numPage", courses.getNumber());
		model.addAttribute("nextPage", courses.getNumber() + 1);
		model.addAttribute("prevPage", courses.getNumber() - 1);
		return "admin";
	}

	@RequestMapping("/adminPage/manageCourses/delete/{id}")
	public String manageGroupsDelete(@PathVariable long id) throws InterruptedException {
		Course course = courseRepository.findOne(id);
		courseRepository.delete(course);
		Thread.sleep(3000);
		return "redirect:/adminPage/manageCourses";
	}

	// NEW, goes to Course Repository 

	@RequestMapping("/adminPage/manageCourses/addCourse")
	public String addCourse(Model model) {
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
		courseService.createNewCourse2(name, category, description, file, listSchedule);
		return "redirect:/adminPage/manageCourses";
	}
	
	// For the AdminRestController without HTML 

//	@RequestMapping("/adminPage/manageCourses/edit/{id}")
//	public String editedCourse(Model model) {
//		model.addAttribute("editCourse", true);
//		EnumSet<Category> categories = EnumSet.allOf(Category.class);
//		model.addAttribute("categories", categories);
//		return "/editCourse";
//	}

	@PostMapping("/adminPage/manageCourses/editCourse")
	public String editedCourse(@PathVariable long id, @RequestParam String name, @RequestParam Category category,
			@RequestParam String description, @RequestParam MultipartFile file, @RequestParam String schedules) {
		String[] schedule = schedules.split(" ");
		List<Schedule> listSchedule = new ArrayList<Schedule>();
		for (String item : schedule) {
			Schedule subSchedule = new Schedule(item);
			listSchedule.add(subSchedule);
		}

		Course course = courseRepository.findOne(id);
		courseRepository.delete(course);

		courseService.createNewCourse2(name, category, description, file, listSchedule);

		return "redirect:/adminPage/manageCourses";
	}



		@RequestMapping("/adminPage/graphics")
		public String graphics(Model model, String action) {
			model.addAttribute("graphicsSection", true);
            Map<String,String> stats = new HashMap<>();

            for(Category category: Category.values()) {
                List<Course> courses = courseRepository.findByCategory(category);
                stats.put(category.name(),String.valueOf(courses.size()));
            }
            Set<Map.Entry<String,String>> statsEntrySet = stats.entrySet();
            model.addAttribute("stats",statsEntrySet);
			return "admin";
		}
}
