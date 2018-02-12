package FitURJC.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping (value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
//	@Autowired
//	private UserComponent userComponent;
	
	@RequestMapping (value = "/")
	public String userProfile(Model model, HttpServletRequest request) {
		
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses",courses);
		return "courses";
	}
}
