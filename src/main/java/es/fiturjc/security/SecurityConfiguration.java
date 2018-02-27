package es.fiturjc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages

		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/newUser").permitAll();

		// User Pages
		http.authorizeRequests().antMatchers("/courses").hasAnyRole("USER");
		
		//Admnin pages
		http.authorizeRequests().antMatchers("/adminPanel/*").hasAnyRole("ADMIN");

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
	protected void configure(AuthenticationManagerBuilder auth) {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}
}
