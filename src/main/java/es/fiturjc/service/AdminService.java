package es.fiturjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fiturjc.model.User;
import es.fiturjc.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository usersRepository;

	
	public boolean deleteUser (Long id) {
		User user = usersRepository.findOne(id);
		if((user != null) && (!user.isAdmin())){
			usersRepository.delete(user);
			return true;
		}
		return false;
	}
	
	public User editUser(Long id, User userNew,String newPassword) throws Exception {
		User userOld = usersRepository.getOne(id);
		if(userOld != null) {
			userOld.setAge(userNew.getAge());
			userOld.setEmail(userNew.getEmail());
			userOld.changePassword(newPassword);
			userOld.setImgSrc("/img/uploads/default");
			userOld.setSurname(userNew.getSurname());
			userOld.setName(userNew.getName());
			usersRepository.save(userOld);
			return userOld;
		}else {
			throw new Exception("User not found");
		}
	}
	
}
