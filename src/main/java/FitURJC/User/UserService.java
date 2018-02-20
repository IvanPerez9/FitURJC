package fiturjc.user;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private urTeamService imageService;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUser(String nickname) {
		return userRepository.findByNickname(nickname);
	}

	public User findOne(long id) {
		return userRepository.findOne(id);
	}

	public User createNewUser(User user, String pass ) {
		if (userRepository.findByNickname(user.getNickname()) == null) {
			ArrayList<String> roles = new ArrayList<>(Arrays.asList("ROLE_USER"));
			user.setRoles(roles);
			user.changePassword(pass);
			userRepository.save(user);
			return user;
		} else {
			return null;
		}
	}

	public User updateUserInfo(String nickname, User user) {
		User userToEdit = userRepository.findByNickname(nickname);
		if (userToEdit != null) {
			user.setId(userToEdit.getId());
			user.changePassword(userToEdit.getPasswordHash());
			userRepository.save(user);
			return user;
		} else {
			return null;
		}
	}

}

