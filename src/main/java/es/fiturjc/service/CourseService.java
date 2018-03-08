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
		return courseRepository.findAll(new PageRequest(0, 6));
	}

	public Page<Course> moreCourses(int page) {
		return courseRepository.findAll(new PageRequest(page, 6));
	}

	public Course findCourse(long id) {
		return courseRepository.findOne(id);
	}

	public Course createNewCourse(Course course, MultipartFile file) {
		
		if (!file.isEmpty()) {
			course.setSrc(imageService.uploadImage(file));
		} else {
			course.setSrc("/uploads/img/default");
		}
		courseRepository.save(course);
		return course;
	}
	
	public Course createNewCourse2 (String name, Category category, String description, MultipartFile file,
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

	// New , viene de Admin controller

	public boolean deleteCourse(long id) {
		Course c = courseRepository.findOne(id);
		if (c != null) {
			courseRepository.delete(c);
			return true;
		}
		return false;
	}
	
	public Course saveCourse (Course c) {
		courseRepository.save(c);
		return c ;
	}

	public Course editCourse(Course c, long id) {
		
		Course courseOld = courseRepository.getOne(id);
		courseOld.setCategory(c.getCategory());
		courseOld.setDescription(c.getDescription());
		courseOld.setName(c.getName());
		courseOld.setSrc(c.getSrc());
		courseOld.setSchedules(c.getSchedules());
		saveCourse(courseOld);
		return courseOld;
		
	}

}
