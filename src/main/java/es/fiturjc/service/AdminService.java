package es.fiturjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import es.fiturjc.model.Course;
import es.fiturjc.model.User;
import es.fiturjc.repository.CourseRepository;
import es.fiturjc.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository usersRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	
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
	
	public User updateUserInfo(long id, User user) {
		User userToEdit = usersRepository.findById(id);
		if(user.getEmail()!= null) {
			userToEdit.setEmail(user.getEmail());
		}
		if(user.getName()!= null) {
			userToEdit.setName(user.getName());
		}
		if(user.getSurname()!= null) {
			userToEdit.setSurname(user.getSurname());
		}
		if(user.getPasswordHash()!= null) {
			userToEdit.changePassword(user.getPasswordHash());
		}
		if(user.getImgSrc()!= null) {
			userToEdit.setImgSrc(user.getImgSrc());
		}
		if(user.getAge() != userToEdit.getAge()) {
			userToEdit.setAge(user.getAge());
		}
		
		usersRepository.save(userToEdit);
		return userToEdit;
	}
	
	// Courses in CourseService

	
	
}
