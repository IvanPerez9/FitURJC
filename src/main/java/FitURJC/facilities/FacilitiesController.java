package FitURJC.facilities;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/facilities")

public class FacilitiesController {
	
	@Autowired
	private FacilitiesRepository facilitiesRepository;
	
	@RequestMapping (value = "/")
	public String userProfile (Model model, HttpServletRequest request) {
		
		List<Facilities> facilities = facilitiesRepository.findAll();
		model.addAttribute("facilities", facilities);
		return "facilities";
	}
	
}
