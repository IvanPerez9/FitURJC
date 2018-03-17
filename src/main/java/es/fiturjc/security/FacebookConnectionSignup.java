package es.fiturjc.security;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public String execute(Connection<?> connection) {
        UserProfile up = connection.fetchUserProfile();
        User user = new User(up.getFirstName(), up.getLastName(), 25, Integer.toHexString(new Random().nextInt(99999999)), up.getEmail(), up.getUsername(),true, "ROLE_USER");
        user.setImgSrc(connection.getImageUrl());;
        userRepository.save(user);
        return user.getName();
    }
}
