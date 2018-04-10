package es.fiturjc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@Order(1)
@EnableWebSecurity
public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider userRepoAuthProvider;

	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		// URLs that need authentication to access to it
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/courses/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/courses/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/courses/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/register").permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/logIn").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/logOut").hasRole("USER");
	
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/admin/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("USER");	
		http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/user/**").hasRole("USER");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/schedules/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/schedules/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/schedules/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/schedules/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/schedules/**").hasRole("ADMIN");		
			
		
		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement with ng2)
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authentication) throws Exception {

		// Database authentication provider
		authentication.authenticationProvider(userRepoAuthProvider);
	}
}
