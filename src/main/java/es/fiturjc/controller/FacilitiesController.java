package es.fiturjc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.fiturjc.model.Facilities;
import es.fiturjc.service.FacilitiesService;

@Controller
public class FacilitiesController {
	
	@Autowired
	private FacilitiesService facilitiesService;
	
	
	@RequestMapping (value = "/facilities")
	public String userProfile (Model model, HttpServletRequest request) {
		
		Page<Facilities> facilities = facilitiesService.getFacilities();
		model.addAttribute("facilities", facilities);
		return "facilities";
	}
	
	
	@RequestMapping(value = "/moreFacilities")
	  public String moreAllShelf(Model model, @RequestParam int page) {
		
	    Page<Facilities> facilities = facilitiesService.moreFacilities(page);
	    model.addAttribute("facility", facilities);
	    return "list_facilities";
	  }
	
}
