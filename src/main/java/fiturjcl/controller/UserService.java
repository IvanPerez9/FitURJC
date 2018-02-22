package fiturjcl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fiturjcl.user.User;
import fiturjcl.user.UserDto;
import fiturjcl.user.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	    public User registerNewUserAccount(UserDto accountDto) {
	        User user = new User();    
	        user.setName(accountDto.getFirstName());
	        user.setSurname(accountDto.getLastName());
	        user.changePassword(accountDto.getPassword());
	        user.setEmail(accountDto.getEmail());
	        user.setRoles(Arrays.asList("ROLE_USER"));
	        return repository.save(user);       
	    }

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
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

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
