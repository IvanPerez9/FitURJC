package es.fiturjc.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import es.fiturjc.model.Schedule;
import es.fiturjc.repository.CourseRepository;
import es.fiturjc.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Category;
import es.fiturjc.model.Course;
import es.fiturjc.model.Facilities;
import es.fiturjc.model.User;
import es.fiturjc.service.CourseService;
import es.fiturjc.service.UserService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private UserComponent userComponent;

	@Autowired
	ScheduleRepository scheduleRepository;

	@RequestMapping(value = "/courses")
	public String getCourses(Model model, Principal principal) {
		boolean isLogged = principal != null;
		User visitor = (isLogged) ? userService.findByEmail(principal.getName()) : null;
		Page<Course> courses = courseService.getPageCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("visitor", visitor);
		return "courses";
	}
	
	@RequestMapping(value = "/moreCourses")
	public String getMoreCourses(Model model, @RequestParam int page) {
		Page<Course> courses = courseService.moreCourses(page);
	    model.addAttribute("course", courses);
	    return "list_courses";
	}

	
	@GetMapping("/courses/{idSchedule}/add")
	public String addCourse(@PathVariable long idSchedule) throws InterruptedException {

		if(!userComponent.isLoggedUser())
			return "redirect:/403.html";

		User user =  userComponent.getLoggedUser();

		Schedule sch = scheduleRepository.findOne(idSchedule);
		if(sch == null)
			return "redirect:/404.html";

		sch.addUser(user);

		//CascadeAll
		scheduleRepository.save(sch);
		
		Thread.sleep(2000);
		return "redirect:/user/profile";
	}
	
	@GetMapping("/courses/{idSchedule}/delete")
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
	
	//Editing a course - SOON 
	
	@GetMapping("/courses/{idSchedule}/edit")
	public String editCourse(@PathVariable long idSchedule, String name, Category category,String description,MultipartFile file,String schedules) throws InterruptedException {

		if(!userComponent.isLoggedUser())
			return "redirect:/403.html";

		User user =  userComponent.getLoggedUser();

		Schedule sch = scheduleRepository.findOne(idSchedule);
		if(sch == null)
			return "redirect:/404.html";

		Course course = sch.getCourse();
		String[] schedule = schedules.split(" ");
		List<Schedule> listSchedule = new ArrayList<Schedule>();
		for (String item : schedule) {
			Schedule subSchedule = new Schedule(item);
			listSchedule.add(subSchedule);
		}
		
		course.setName(name);
		course.setCategory(category);
		course.setDescription(description);
		course.setSchedules(listSchedule);
		courseRepository.save(course);

		return "redirect:/user/profile";
	}
	
	
}
