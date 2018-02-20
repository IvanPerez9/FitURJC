package fiturjcl.facilities;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacilitiesController {
	
	@Autowired
	private FacilitiesRepository facilitiesRepository;
	
	
	@RequestMapping (value = "/facilities")
	public String userProfile (Model model, HttpServletRequest request) {
		
		Page<Facilities> facilities = facilitiesRepository.findAll(new PageRequest(0,10));
		model.addAttribute("facilities", facilities);
		return "facilities";
	}
	
	
	@RequestMapping(value = "/moreFacilities")
	  public String moreAllShelf(Model model, @RequestParam int page) {
		
	    Page<Facilities> facilities = facilitiesRepository.findAll(new PageRequest(page, 10));
	    model.addAttribute("facility", facilities);
	    return "list_facilities";
	  }
	
}
