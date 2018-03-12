package es.fiturjc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.fiturjc.model.Course;
import es.fiturjc.model.Schedule;
import es.fiturjc.repository.ScheduleRepository;
import es.fiturjc.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleRestController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	//@JsonView(CourseDetail.class)
	public ResponseEntity<Schedule> getCourseId(@PathVariable long id) {
		Schedule schedule = scheduleService.findById(id);
		if (schedule != null) {
			return new ResponseEntity<>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
