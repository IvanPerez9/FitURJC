package es.fiturjc.security;

import java.util.Arrays;

import es.fiturjc.component.UserComponent;
import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.Oneway;

@Component
public class FacebookSignInAdapter implements SignInAdapter {

    UserRepository userRepository;

    public FacebookSignInAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {

        User u = userRepository.findByEmail(localUserId);

        if(u == null){
            throw new IllegalStateException("User tried to sign in with FB but the profile does not exist");
        }
        SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(
          new UsernamePasswordAuthenticationToken(
          localUserId, connection.getImageUrl(),
          Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));

        return null;
    }

}
