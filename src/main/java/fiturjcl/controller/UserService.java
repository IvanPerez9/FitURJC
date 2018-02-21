package fiturjcl.controller;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fiturjcl.user.User;
import fiturjcl.user.UserDto;
import fiturjcl.user.UserRepository;
/* NUEVO
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
}*/
