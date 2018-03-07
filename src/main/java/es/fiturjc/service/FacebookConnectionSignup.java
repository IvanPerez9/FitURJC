package es.fiturjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setName(connection.getDisplayName());
        user.setPasswordHash(randomAlphabetic(8));
        userRepository.save(user);
        return user.getName();
    }

	private String randomAlphabetic(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
