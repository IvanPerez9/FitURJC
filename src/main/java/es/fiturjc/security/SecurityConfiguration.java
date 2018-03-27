package es.fiturjc.security;

import es.fiturjc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
//	//facebook
// 	@Autowired
//    private UserDetailsService userDetailsService;
 	
 	@Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;
  
    @Autowired
    private UsersConnectionRepository usersConnectionRepository;
  
    @Autowired
    private FacebookConnectionSignup facebookConnectionSignup;

    @Autowired
	private UserRepository userRepository;
     
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages

		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/newUser").permitAll();
		//facebook
 		http.authorizeRequests().antMatchers("/signin/**","/signup/**").permitAll();
//		http.apply(getSpringSocialConfigurer());

		// User Pages
		http.authorizeRequests().antMatchers("/courses").hasAnyRole("USER");
		
		//Admin pages
		http.authorizeRequests().antMatchers("/adminPage/**").hasAnyRole("ADMIN");

		// Login form
		http.formLogin().loginPage("/login");

		// Login parameter names
		http.formLogin().usernameParameter("email");
		http.formLogin().passwordParameter("password");

		// Redirect Url on success and on failure
		http.formLogin().defaultSuccessUrl("/user/profile");
		http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		// Disable CSRF Protection, not compatible with current version of Mustache
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{ // mirar ejercicio de seguridad, http.httpBasic() y http.logout y tal 
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
		
		//facebook
//		auth.userDetailsService(userDetailsService);
	}
	
//	//facebook
// 	@Bean
//     public ProviderSignInController providerSignInController() {
//         usersConnectionRepository
//           .setConnectionSignUp(facebookConnectionSignup);
//          
//         return new ProviderSignInController(
//           connectionFactoryLocator, 
//           usersConnectionRepository, 
//           new FacebookSignInAdapter(userRepository));
//     }
	 	
	 	
// 	private SocialConfigurer getSpringSocialConfigurer() {
// 	    SpringSocialConfigurer config = new SpringSocialConfigurer();
// 	    config.alwaysUsePostLoginUrl(true);
// 	    config.postLoginUrl("/profile?login=true");
// 
// 	    return config;
// 	}
}
