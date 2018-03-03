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
	public void run(String... arg0) {
		
		//DEFAULT USERS

		User user1 = new User("William", "Wallace", 25, "pass", "ww@gmail.com", "WW", "ROLE_USER");
		user1.setImgSrc("/uploads/img/default");
		User user2 = new User("Travis", "Filmer", 29, "pass", "tt@gmail.com", "TF", "ROLE_USER");
		user2.setImgSrc("/uploads/img/default");
		User user3 = new User("Cillian", "Murphy", 28, "pass", "cm@gmail.com", "CM", "ROLE_USER");
		user3.setImgSrc("/uploads/img/default");
		// Admin user 
		
		User user4 = new User("Admin", "Admin", 25, "pass", "admin@gmail.com", "admin","ROLE_USER", "ROLE_ADMIN");
		user4.setImgSrc("/uploads/img/default");
		
		Schedule schedule1 = new Schedule ("10:00-11:00");
		Schedule schedule2 = new Schedule ("11:00-12:00");
		Schedule schedule3 = new Schedule ("12:00-13:00");
        Schedule schedule4 = new Schedule ("17:00-18:00");
        Schedule schedule5 = new Schedule ("18:00-19:00");
        Schedule schedule6 = new Schedule ("10:00-11:00");
        Schedule schedule7 = new Schedule ("11:00-12:00");
        Schedule schedule8 = new Schedule ("12:00-13:00");
        Schedule schedule9 = new Schedule ("17:00-18:00");
        Schedule schedule10 = new Schedule ("18:00-19:00");
        Schedule schedule11 = new Schedule ("10:00-11:00");
		Schedule schedule12 = new Schedule ("11:00-12:00");
		Schedule schedule13 = new Schedule ("12:00-13:00");
        Schedule schedule14 = new Schedule ("17:00-18:00");
        Schedule schedule15 = new Schedule ("18:00-19:00");
        Schedule schedule16 = new Schedule ("10:00-11:00");
        Schedule schedule17 = new Schedule ("11:00-12:00");
        Schedule schedule18 = new Schedule ("12:00-13:00");
        Schedule schedule19 = new Schedule ("17:00-18:00");
        Schedule schedule20 = new Schedule ("18:00-19:00");
        Schedule schedule21 = new Schedule ("10:00-11:00");
		Schedule schedule22 = new Schedule ("11:00-12:00");
		Schedule schedule23 = new Schedule ("12:00-13:00");
        Schedule schedule24 = new Schedule ("17:00-18:00");
        
        //ADD THE COURSES WITH THEIR SCHEDULE

        Course course1 = new Course("Aerobic", Category.CARDIO, "Turn your heartbeat up while you dance to the latest music hits! A real fat burning session", schedule1, schedule2);
        schedule1.setCourse(course1);
        schedule2.setCourse(course1);
        course1.setSrc("/uploads/img/img-20180302-051042-655");

		Course course2 = new Course("Body Combat", Category.CARDIO, "Release adrenaline and gain strength with this Japanese sport. The king of all contact sports", schedule3, schedule4);
		schedule3.setCourse(course2);
		schedule4.setCourse(course2);
		course2.setSrc("/uploads/img/img-20180302-051042-655");

		Course course10 = new Course("Boxing", Category.CARDIO, "Where to practice boxing and learn the values ​​of boxing beyond combat.", schedule5, schedule6);
		schedule5.setCourse(course10);
		schedule6.setCourse(course10);
		course10.setSrc("/uploads/img/img-20180302-051042-655");
		
		Course course11 = new Course("Cardio", Category.CARDIO, "Great offer with different aerobic training equipment", schedule7, schedule8);
		schedule7.setCourse(course11);
		schedule8.setCourse(course11);
		course11.setSrc("/uploads/img/img-20180302-051042-655");
		
		Course course12 = new Course("CrossFit", Category.CARDIO, "Do you dare with military training? Fit cross, your high intensity activity that adapts to your physical condition", schedule9, schedule10);
		schedule9.setCourse(course12);
		schedule10.setCourse(course12);
		course12.setSrc("/uploads/img/img-20180302-051042-655");
		
		Course course3 = new Course("Dumbbells", Category.CARDIO, "Enjoy the best fitness rooms with the best equipment and training programmes adapted for you, allowing you to get the best from your training.", schedule13, schedule14);
		schedule13.setCourse(course3);
		schedule14.setCourse(course3);
		course3.setSrc("/uploads/img/img-20180302-051042-655");
		
		// STRENGTH CATEGORIES
		Course course4 = new Course("Pilates", Category.STRENGTH, "system of exercises of stretching and muscular strengthening, it also helps us to unify body and mind", schedule15, schedule16);
		schedule15.setCourse(course4);
		schedule16.setCourse(course4);
		course4.setSrc("/uploads/img/img-20180302-051042-655");
		
		// FREESTYLE CATEGORIES
		Course course5 = new Course("Spinning", Category.FREESTYLE, "Are those group activities that are aimed to improve the cardiorespiratory system and result in increased aerobic capacity and decreased body fat", schedule17, schedule18);
		schedule17.setCourse(course5);
		schedule18.setCourse(course5);
		course5.setSrc("/uploads/img/img-20180302-051042-655");
		
		Course course6 = new Course("Step", Category.FREESTYLE, "Step is low-impact physical training to improve resistance, strength and flexibility.", schedule19, schedule20);
		schedule19.setCourse(course6);
		schedule20.setCourse(course6);
		course6.setSrc("/uploads/img/img-20180302-051042-655");
		
		// DANCE CATEGORIES
		Course course7 = new Course("Swiming", Category.DANCE, "If you like water-based training, aqua is the activity for you!", schedule21, schedule22);
		schedule21.setCourse(course7);
		schedule22.setCourse(course7);
		course7.setSrc("/uploads/img/img-20180302-051042-655");
		
		Course course8 = new Course("Switching circuit", Category.DANCE, "If you want to try different activities and you like to alternate rhythms and disciplines, find the class that works for you in our range of mixed classes.", schedule23, schedule24);
		schedule23.setCourse(course8);
		schedule24.setCourse(course8);
		course8.setSrc("/uploads/img/img-20180302-051042-655");
		
		// MIND CATEGORIES
		Course course9 = new Course("Yoga", Category.MIND, "Exercises to stretch, strengthen and balance the body. Improves posture, provides flexibility and balance, unifies mind and body and creates a more stylized figure.", schedule11, schedule12);
		schedule11.setCourse(course9);
		schedule12.setCourse(course9);
		course9.setSrc("/uploads/img/img-20180302-051042-655");
		
		
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
	

	/*	user2.addCourse(course1);*/
		schedule1.addUser(user1);
		schedule1.addUser(user2);
		schedule1.addUser(user3);
		schedule2.addUser(user2);



		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		// Admin save 
		userRepository.save(user4);

		for (int i = 1; i <= 40; i++) {
			facilitiesRepository.save(new Facilities("/img/facilities/facilities_" + i + ".jpeg"));
		}

	}

}
