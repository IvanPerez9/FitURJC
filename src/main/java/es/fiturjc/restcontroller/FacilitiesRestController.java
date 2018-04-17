package es.fiturjc.restcontroller;

import java.util.List;

import org.hibernate.SharedSessionContract;
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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.facilities;
import es.fiturjc.model.User;
import es.fiturjc.service.FacilitiesService;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api/facilities")
public class FacilitiesRestController {

	interface FacilitiesDetail extends Facilities.Basic,Facilities.Details{
	}

	@Autowired
	private FacilitiesService facilitiesService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserComponent userComponent;


	/**
	 *
	 * @return
	 */

	public interface FacilitiesDetails extends Facilities.Basic, Facilities.Details,User.Basic{}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@JsonView(CourseDetails.class)
	public ResponseEntity<List<Facilities>> getFacilities() {
		List<Facilities> facilities = facilitiesService.get;
		if (courses != null) {
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



}
