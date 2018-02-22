package fiturjc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import fiturjcl.user.User;
import fiturjcl.user.UserDto;
import fiturjcl.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

public class RegisterController {
	
	/*@RequestMapping("/Register/{id}")
    public String userProfile(Model model, @PathVariable long id, HttpServletRequest request) {
        
    }*/
	
	@Autowired
	private UserService service;
	

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
	  @ModelAttribute("user") @Valid UserDto accountDto, 
	  BindingResult result, 
	  WebRequest request, 
	  Errors errors) {
	     
	    User registered = new User();
	    if (!result.hasErrors()) {
	        registered = createUserAccount(accountDto, result);
	    }
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    } 
	    else {
	        return new ModelAndView("successRegister", "user", accountDto);
	    }
	}
	private User createUserAccount(UserDto accountDto, BindingResult result) {
	    User registered = null;
	    registered = service.registerNewUserAccount(accountDto);
	    return registered;
	}

}
