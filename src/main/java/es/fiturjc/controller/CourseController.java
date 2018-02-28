package es.fiturjc.controller;

import java.security.Principal;
import java.util.List;

import es.fiturjc.model.Schedule;
import es.fiturjc.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.service.CourseService;
import es.fiturjc.service.UserService;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserComponent userComponent;

	@Autowired
	ScheduleRepository scheduleRepository;

	@RequestMapping(value = "")
	public String getCourses(Model model, Principal principal) {
		boolean isLogged = principal != null;
		User visitor = (isLogged) ? userService.findByEmail(principal.getName()) : null;
		List<Course> courses = courseService.getAllCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("visitor", visitor);
		return "courses";
	}

	
	@GetMapping("/{idSchedule}/add")
	public String addCourse(@PathVariable long idSchedule) throws InterruptedException {

		if(!userComponent.isLoggedUser())
			return "redirect:/403.html";

		User user =  userComponent.getLoggedUser();

		Schedule sch = scheduleRepository.findOne(idSchedule);
		if(sch == null)
			return "redirect:/404.html";

		sch.addUser(user);

		// Esta en CascadeAll
		scheduleRepository.save(sch);
		
		Thread.sleep(2000);
		return "redirect:/user/profile";
	}
	
	@GetMapping("/{idSchedule}/delete")
	public String deleteCourse(@PathVariable long idSchedule) throws InterruptedException {

		if(!userComponent.isLoggedUser())
			return "redirect:/403.html";

		User user =  userComponent.getLoggedUser();

		Schedule sch = scheduleRepository.findOne(idSchedule);
		if(sch == null)
			return "redirect:/404.html";

		
		sch.deleteUser(user);

		scheduleRepository.save(sch);
		
		Thread.sleep(2000);
		return "redirect:/user/profile";
	}
	
}
