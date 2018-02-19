package FitURJC.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping (value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
//	@Autowired
//	private UserComponent userComponent;
	
	@RequestMapping (value = "")
	public String userProfile(Model model) {
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses",courses);
		return "courses";
	}
}
