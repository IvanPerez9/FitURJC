package es.fiturjc.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.fiturjc.model.Category;
import es.fiturjc.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.fiturjc.model.Course;
import es.fiturjc.model.Facilities;
import es.fiturjc.model.User;
import es.fiturjc.repository.CourseRepository;
import es.fiturjc.repository.ScheduleRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private ImageService imageService;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Page<Course> getPageCourses() {
		return courseRepository.findAll(new PageRequest(0, 10));
	}

	public Page<Course> moreCourses(int page) {
		return courseRepository.findAll(new PageRequest(page, 10));
	}
	
	public Course findCourse(long id) {
		return courseRepository.findOne(id);
	}

	public void follow(User user, Course course) {
		if (user.getCourseList().contains(course)) {
			user.removeCourse(course);
		} else {
			user.addCourse(course);
		}
	}

	public Course createNewCourse(String name, Category category, String description, MultipartFile file,
			List<Schedule> schedules) {
		Course course = new Course(name, category, description, schedules);
		
		if (!file.isEmpty()) {
			course.setSrc(imageService.uploadImage(file));
		} else {
			course.setSrc("/uploads/img/default");
		}
		for(Schedule schedule:schedules) {
			schedule.setCourse(course);
		}
		courseRepository.save(course);
		return course;
	}
	
	// New 
	
//	public Course editCourse(String name, Category category, String description, MultipartFile file,
//			List<Schedule> schedules) {
//		
//		Course course = new Course(name, category, description, schedules);
//		
//		if (!file.isEmpty()) {
//			course.setSrc(imageService.uploadImage(file));
//		} else {
//			course.setSrc("/uploads/img/default");
//		}
//		for(Schedule schedule:schedules) {
//			schedule.setCourse(course);
//		}
//		courseRepository.save(course);
//		return course;
//	}
	
}
