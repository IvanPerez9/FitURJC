package FitURJC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import FitURJC.User.User;
import FitURJC.User.UserRepository;
import FitURJC.course.Course;
import FitURJC.course.CourseRepository;
import FitURJC.facilities.Facilities;
import FitURJC.facilities.FacilitiesRepository;

@Controller
public class DatabaseUsage implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	FacilitiesRepository facilitiesRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		
		User user1 = new User("William", "Wallace", 25, "contrasena", "ww@gmail.com", "por escocia", "WW", "ROLE_USER");
		Course course1 = new Course("Spinning", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course2 = new Course("Spinning", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course3 = new Course("Spinning", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course4 = new Course("Spinning", "blablacar", "10:00-11:00", "15:00-16:00");
		
		
		
		
		userRepository.save(user1);
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		for(int i=1; i<= 12; i++){
			for (int j = 1; j <= 5; j++) {
				facilitiesRepository.save(new Facilities("/img/facilities/"+ i +".jpg"));
			}
		}
		
		// Add roles , and string
		
	}

}
