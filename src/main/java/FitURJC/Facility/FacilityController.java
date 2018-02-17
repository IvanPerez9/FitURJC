package FitURJC.Facility;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/facilities")
public class FacilityController {
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@RequestMapping (value = "/")
	public String userProfile (Model model) {
		List<Facility> facility = facilityRepository.findAll();
		model.addAttribute("facility", facility);
		return "facility";
	}
	
}
