package FitURJC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import FitURJC.Facility.Facility;
import FitURJC.Facility.FacilityRepository;
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
	
	@Autowired
	FacilityRepository facilityRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {

		User user1 = new User("William", "Wallace", 25, "contrasena", "ww@gmail.com", "por escocia", "WW", "ROLE_USER");
		
		Course course1 = new Course("Aerobic", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course2 = new Course("Body Combat", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course3 = new Course("CrossFit", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course4 = new Course("Spinning", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course5 = new Course("Step", "blablacar", "10:00-11:00", "15:00-16:00");
		Course course6 = new Course("Zumba", "blablacar", "10:00-11:00", "15:00-16:00");
		
		Facility facility1 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");
		Facility facility2 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");
		Facility facility3 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");
		Facility facility4 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");
		Facility facility5 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");
		Facility facility6 = new Facility("Boxing", "Where to practice boxing and learn the values ​​of boxing beyond combat");

		
		userRepository.save(user1);
		
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		courseRepository.save(course5);
		courseRepository.save(course6);
		
		facilityRepository.save(facility1);
		facilityRepository.save(facility2);
		facilityRepository.save(facility3);
		facilityRepository.save(facility4);
		facilityRepository.save(facility5);
		facilityRepository.save(facility6);
		
		
//		for (int j = 1; j <= 6; j++) {
//			courseRepository.save(new Course("/img/facilities/"+ j +".jpg"));
//		}

		for(int i=1; i<= 12; i++){
			for (int j = 1; j <= 5; j++) {
				facilitiesRepository.save(new Facilities("/img/facilities/"+ i +".jpg"));
			}
		}
		
		// Add roles , and string
		
	}

}
