package fiturjcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import fiturjcl.course.Category;
import fiturjcl.course.Course;
import fiturjcl.course.CourseRepository;
import fiturjcl.facilities.Facilities;
import fiturjcl.facilities.FacilitiesRepository;
import fiturjcl.user.User;
import fiturjcl.user.UserRepository;

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
		
		Course course1 = new Course("Pro Cycling", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course2 = new Course("Aqua Aerobic", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course11 = new Course("Pro Cycling", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course12 = new Course("Aqua Aerobic", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course13 = new Course("Pro Cycling", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course14 = new Course("Aqua Aerobic", Category.CARDIO, "blablacar", "10:00-11:00", "15:00-16:00");
	    // STRENGTH CATEGORIES
	    Course course3 = new Course("BodyPump", Category.STRENGTH, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course4 = new Course("BodyPump", Category.STRENGTH, "blablacar", "10:00-11:00", "15:00-16:00");
	    // FREESTYLE CATEGORIES
	    Course course5 = new Course("Bosu", Category.FREESTYLE, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course6 = new Course("Freestyle group training outdoor", Category.FREESTYLE, "blablacar", "10:00-11:00",
	        "15:00-16:00");
	    // DANCE CATEGORIES
	    Course course7 = new Course("Zumba", Category.DANCE, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course8 = new Course("Love to dance", Category.DANCE, "blablacar", "10:00-11:00", "15:00-16:00");
	    // MIND CATEGORIES
	    Course course9 = new Course("BodyBalance", Category.MIND, "blablacar", "10:00-11:00", "15:00-16:00");
	    Course course10 = new Course("Yoga", Category.MIND, "blablacar", "10:00-11:00", "15:00-16:00");

		
		userRepository.save(user1);
		
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		courseRepository.save(course5);
		courseRepository.save(course6);
		courseRepository.save(course7);
		courseRepository.save(course8);
		courseRepository.save(course9);
		courseRepository.save(course10);
		courseRepository.save(course11);
		courseRepository.save(course12);

		
//		for(int i=1; i<=12; i++) {
//			courseRepository.save(new Course("/img/course/course_"+ i +".jpg"));
//		}
		
		for(int i=1; i<=40; i++){
			//for (int j = 1; j <= 5; j++) {
				facilitiesRepository.save(new Facilities("/img/facilities/facilities_"+ i +".jpeg"));
			//}
		}
		
		// Add roles , and string
		
	}

}
