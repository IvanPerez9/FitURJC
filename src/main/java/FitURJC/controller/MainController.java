package FitURJC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import FitURJC.course.Course;
import FitURJC.course.CourseRepository;

@Controller
public class MainController {

	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value = "/")
	public String getIndex(Model model) {
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses",courses);
		return "index";
		}
	
	
}
