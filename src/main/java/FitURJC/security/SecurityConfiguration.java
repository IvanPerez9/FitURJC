package FitURJC.security;

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
        http.authorizeRequests().antMatchers("/events").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/groups").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/group/*").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/addGroup").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/addEvent").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/user/*").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/event/*/follow").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/GroupAdded").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/eventAdded").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/moreGroups").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/adminPanel/*").hasAnyRole("ADMIN");

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("nickname");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }
}
