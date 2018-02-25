package es.fiturjc.service;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


import es.fiturjc.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import es.fiturjc.repository.CourseRepository;
import es.fiturjc.model.Course;
import es.fiturjc.model.Schedule;
import es.fiturjc.model.User;
import es.fiturjc.repository.ScheduleRepository;
import es.fiturjc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private ImageService imageService;

	@Autowired
	private CourseRepository courseRepository;

	private static final long MAXIMUM_RECOMMENDED_COURSES = 3;

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUser(String nickname) {
		return userRepository.findByNickname(nickname);
	}

	public User findOne(long id) {
		return userRepository.findOne(id);
	}

	public User createNewUser(User user, String pass) {
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

	public void setImage(User u, MultipartFile file) {
		if (imageService.isValidImage(file)) {
			u.setImgSrc(imageService.uploadImage(file));
			userRepository.save(u);
		}
	}

	/**
	 * Edit user with all the parameters
	 * 
	 * @param user
	 * @param params
	 */

	public void editUser(User user, Map<String, String> params) {
		for (Entry<String, String> entry : params.entrySet()) {
			switch (entry.getKey()) {
			case "name":
				String newName = entry.getValue();
				if (!newName.isEmpty())
					user.setName(entry.getValue());
				break;
			case "surname":
				String newSurname = entry.getValue();
				if (!newSurname.isEmpty())
					user.setSurname(entry.getValue());
				break;
			case "email":
				String newEmail = entry.getValue();
				if (!newEmail.isEmpty())
					user.setEmail(entry.getValue());
				break;
			case "password":
				String newPassword = entry.getValue();
				if (!newPassword.isEmpty())
					user.changePassword(entry.getValue());
				break; 
			case "age":
				String newAge = entry.getValue();
				if (!newAge.isEmpty())
					user.setAge(Integer.parseInt(entry.getValue()));
				break;
			default:
				break;
			}
		}
		userRepository.save(user);
	}

	public User findByNickname(User u) {
		return userRepository.findByNickname(u.getNickname());
	}

	public User createNewUser(String nickname, String name, String surname, String email, String password, String age) {
		User user = new User(name,surname,Integer.parseInt(age),password,email, nickname,"ROLE_USER");
		userRepository.save(user);
		return user;
		
	//	User user1 = new User("William", "Wallace", 25, "pass", "ww@gmail.com", "WW", "ROLE_USER");
	}

	// MAL MAL MAL
//	public User addUserToSchedule(User user, Course course, Schedule schedule) {
//		schedule.annadirUsuario(user);
//		userRepository.save(user);
//		return user;
//	}

    public Collection<Course> getRecommendedCoursesForUser(User u){
       Optional<Entry<Category, Long>> favouriteCategory = getCourses(u).stream().map(Course::getCategory)
               .collect(Collectors.groupingBy(category -> category, Collectors.counting()))
               .entrySet().stream().max(Comparator.comparingLong(Entry::getValue));

       if(!favouriteCategory.isPresent()){
           return null;
       }

       Set<Course> coursesEnrrolled = new HashSet<>(this.getCourses(u));

        return courseRepository.findByCategory(favouriteCategory.get().getKey())
                .stream()
                .filter(c -> !coursesEnrrolled.contains(c))
                .collect(Collectors.toList());
    }

    public List<Course> getCourses(User u){
        return scheduleRepository
                .findByListUsersContains(u)
                .stream().map(Schedule::getCourse)
                .collect(Collectors.toList());
    }


}
