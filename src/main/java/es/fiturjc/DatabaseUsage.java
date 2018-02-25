package es.fiturjc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.fiturjc.model.Category;
import es.fiturjc.model.Course;
import es.fiturjc.model.Facilities;
import es.fiturjc.model.Schedule;
import es.fiturjc.model.User;
import es.fiturjc.repository.CourseRepository;
import es.fiturjc.repository.FacilitiesRepository;
import es.fiturjc.repository.UserRepository;
import es.fiturjc.repository.ScheduleRepository;

@Controller
public class DatabaseUsage implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private FacilitiesRepository facilitiesRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Override
	public void run(String... arg0) throws Exception {

		User user1 = new User("William", "Wallace", 25, "pass", "ww@gmail.com", "WW", "ROLE_USER");
		user1.setImgSrc("/uploads/img/default");
		User user2 = new User("Chemi", "G", 99, "pass", "chemi@email.com", "chemg", "ROLE_USER");
		user2.setImgSrc("/uploads/img/default");
		User user3 = new User("Cucu", "tras", 99, "pass", "chemi2@email.com", "cucutras", "ROLE_USER");
		user3.setImgSrc("/uploads/img/default");
		
		Schedule schedule1 = new Schedule ("10:00-11:00");
		Schedule schedule2 = new Schedule ("15:00-16:00");
		Schedule schedule3 = new Schedule ("17:00-17:30");
		
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		List<Schedule> scheduleList2 = new ArrayList<Schedule>();
		
		// Add schedule to a schedule list. Fix with the schedule part on users 
		scheduleList.add(schedule1);
		scheduleList.add(schedule2);
	//	scheduleList.add(schedule3);
	
	//	scheduleList2.add(schedule1);
	//	scheduleList2.add(schedule2);
		scheduleList2.add(schedule3);
		
//		scheduleRepository.save(schedule1);
//		scheduleRepository.save(schedule2);
//		scheduleRepository.save(schedule3);
		
		Course course1 = new Course("Aerobic", Category.CARDIO, "Turn your heartbeat up while you dance to the latest music hits! A real fat burning session", scheduleList );
		Course course2 = new Course("Body Combat", Category.CARDIO, "Release adrenaline and gain strength with this Japanese sport. The king of all contact sports", scheduleList2);
		Course course10 = new Course("Boxing", Category.CARDIO, "Where to practice boxing and learn the values ​​of boxing beyond combat.", null);
		Course course11 = new Course("Cardio", Category.CARDIO, "Great offer with different aerobic training equipment", null);
		Course course12 = new Course("CrossFit", Category.CARDIO, "Do you dare with military training? Fit cross, your high intensity activity that adapts to your physical condition", null);
		Course course13 = new Course("Dumbbells", Category.CARDIO, "Enjoy the best fitness rooms with the best equipment and training programmes adapted for you, allowing you to get the best from your training.", null);
		// STRENGTH CATEGORIES
		Course course3 = new Course("Physical Therapy", Category.STRENGTH, "Physiotherapy is considered a key treatment in rehabilitation for people who play sport, who have some injury or condition", null);
		Course course4 = new Course("Pilates", Category.STRENGTH, "system of exercises of stretching and muscular strengthening, it also helps us to unify body and mind", null);
		// FREESTYLE CATEGORIES
		Course course5 = new Course("Spinning", Category.FREESTYLE, "Are those group activities that are aimed to improve the cardiorespiratory system and result in increased aerobic capacity and decreased body fat", null);
		Course course6 = new Course("Step", Category.FREESTYLE, "Step is low-impact physical training to improve resistance, strength and flexibility.", null);
		// DANCE CATEGORIES
		Course course7 = new Course("Swiming", Category.DANCE, "If you like water-based training, aqua is the activity for you!", null);
		Course course8 = new Course("Switching circuit", Category.DANCE, "If you want to try different activities and you like to alternate rhythms and disciplines, find the class that works for you in our range of mixed classes.", null);
		// MIND CATEGORIES
		Course course9 = new Course("Yoga", Category.MIND, "Exercises to stretch, strengthen and balance the body. Improves posture, provides flexibility and balance, unifies mind and body and creates a more stylized figure.", null);		
		
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
		courseRepository.save(course13);
	

		user2.addCourse(course1);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		for (int i = 1; i <= 40; i++) {
			facilitiesRepository.save(new Facilities("/img/facilities/facilities_" + i + ".jpeg"));
		}

	}

}
