package es.fiturjc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.Facilities;
import es.fiturjc.service.FacilitiesService;
import es.fiturjc.service.UserService;

@RestController
@RequestMapping("/api")
public class FacilitiesRestController {

	interface FacilitiesDetail extends Facilities.Basic, Facilities.Details {
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
	@RequestMapping(value = "/facilities", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@JsonView(FacilitiesDetail.class)
	public ResponseEntity<?> getFacilities(Pageable page) {
		Page<Facilities> facilities = facilitiesService.getFacilities(page);
		if (facilities != null) {
			return new ResponseEntity<>(facilities.getContent(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
