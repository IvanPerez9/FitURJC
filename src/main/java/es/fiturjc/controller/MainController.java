package es.fiturjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fiturjc.model.Course;
import es.fiturjc.service.CourseService;

@Controller
public class MainController {

	@Autowired
	private CourseService courseService;

	/**
	 * Index html page
	 * 
	 * @param model
	 *            for the courses
	 * @return the view for the index.
	 */
	@RequestMapping(value = "/")
	public String getIndex(Model model) {
		Page<Course> coursesIndex = courseService.getPageCourses();
		model.addAttribute("courses", coursesIndex);
		return "index";
	}

}
