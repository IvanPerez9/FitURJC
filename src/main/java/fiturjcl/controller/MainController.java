package fiturjcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fiturjcl.course.Course;
import fiturjcl.course.CourseRepository;
import fiturjcl.user.User;
import fiturjcl.user.UserComponent;
import fiturjcl.user.UserRepository;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserComponent userComponent;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/")
	public String getIndex(Model model) {
		Page<Course> coursesIndex = courseRepository.findAll(new PageRequest(0,6));
		model.addAttribute("courses", coursesIndex);
		return "index";
	}


	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403.html");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

				container.addErrorPages(error401Page, error404Page, error403Page, error500Page);
			}
		};
	}
}
