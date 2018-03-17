package es.fiturjc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Course;
import es.fiturjc.model.Schedule;
import es.fiturjc.model.User;
import es.fiturjc.repository.ScheduleRepository;
import es.fiturjc.service.ScheduleService;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleRestController {
	
	interface ScheduleDetails extends Schedule.Basic,Schedule.Details{
	}
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userComponent;
	
	/**
	 * List of all the schedules, join with their course 
	 * @return
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@JsonView(Schedule.Basic.class)
	public ResponseEntity<List<Schedule>> getSchedules() {
		List<Schedule> schedules = scheduleService.getAllSchedule();
		if (schedules != null) {
			return new ResponseEntity<>(schedules, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Get specific schedule 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Schedule> getScheduleID(@PathVariable long id) {
		Schedule schedule = scheduleService.findById(id);
		if (schedule != null) {
			return new ResponseEntity<>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Delete Schedule only for admin 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Schedule> deleteSchedule(@PathVariable long id) {
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if(userLogged.isAdmin()) {
			scheduleService.deleteSchedule(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * Join a Schedule with the logged user . Need to be checked
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}/join", method = RequestMethod.PUT)
	@JsonView(ScheduleDetails.class)
	public ResponseEntity<Schedule> joinSchedule(@PathVariable long id) {
		Schedule schedule = scheduleService.findById(id);
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if (schedule != null && userLogged != null) {
			scheduleService.join(userLogged, schedule);
			scheduleService.save(schedule);
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Same method but different URL to make a difference 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}/unsubscribe", method = RequestMethod.PUT)
	@JsonView(ScheduleDetails.class)
	public ResponseEntity<Schedule> unsubscribeSchedule(@PathVariable long id) {
		Schedule schedule = scheduleService.findById(id);
		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
		if (schedule != null && userLogged != null) {
			scheduleService.join(userLogged, schedule);
			scheduleService.save(schedule);
			return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
		} else {
			return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Edit a Schedule . Needs to be Checked  !!! 
	 * @param id
	 * @param updatedSchedule
	 * @return
	 */
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
//	@JsonView(Schedule.Basic.class)
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	public ResponseEntity<Schedule> updateSchedule(@PathVariable long id, @RequestBody Schedule updatedSchedule) {
//		Schedule schedule = scheduleService.findById(id);
//		User userLogged = userService.findOne(userComponent.getLoggedUser().getId());
//		if (userLogged.isAdmin()) {
//			if (schedule != null && updatedSchedule != null) {
//				updatedSchedule.setIdSchedule(id);
//				scheduleService.save(updatedSchedule);
//				return new ResponseEntity<>(updatedSchedule, HttpStatus.ACCEPTED);
//			} else {
//				return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
//			}
//		} else {
//			return new ResponseEntity<Schedule>(HttpStatus.UNAUTHORIZED);
//		}
//
//	}
	
}
