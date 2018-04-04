package es.fiturjc.service;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


import es.fiturjc.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public User getUserbyID(Long id) {
        return userRepository.findById(id);
    }

    public User findOne(long id) {
        return userRepository.findOne(id);
    }

	public User findOne(String email) {
        return userRepository.findByEmail(email);
	}

    public User createNewUser(User user, String pass) {
        if (userRepository.findByNickname(user.getNickname()) == null) {
            ArrayList<String> roles = new ArrayList<>(Arrays.asList("ROLE_USER"));
            user.setRoles(roles);
            user.setImgSrc("/uploads/img/default");
            user.changePassword(pass);
            userRepository.save(user);
            return user;
        } else {
            return null;
        }
    }

    public User createNewUser2(User user) {
        User u = new User(user.getName(), user.getSurname(), user.getAge(), user.getPasswordHash(), user.getEmail(), user.getNickname(), true, "USER");
        userRepository.save(u);
        return u;
    }

	public User updateUserInfo(long id, User user) {
		User userToEdit = userRepository.findById(id);
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
		if(user.getNickname()!= null) {
			userToEdit.setNickname(user.getNickname());
		}
		if(user.getImgSrc()!= null) {
			userToEdit.setImgSrc(user.getImgSrc());
		}
		if(user.getAge() != userToEdit.getAge()) {
			userToEdit.setAge(user.getAge());
		}
		
		userRepository.save(userToEdit);
		return userToEdit;
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
        User user = new User(name, surname, Integer.parseInt(age), password, email, nickname, true, "ROLE_USER");
        userRepository.save(user);
        return user;
    }

    public Collection<Course> getRecommendedCoursesForUser(User u) {
        Optional<Entry<Category, Long>> favouriteCategory = getCourses(u).stream().map(Course::getCategory)
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Entry::getValue));

        if (!favouriteCategory.isPresent()) {
            return null;
        }

        Set<Course> coursesEnrrolled = new HashSet<>(this.getCourses(u));

        return courseRepository.findByCategory(favouriteCategory.get().getKey())
                .stream()
                .filter(c -> !coursesEnrrolled.contains(c))
                .collect(Collectors.toList());
    }

    public Collection<Course> getCourses(User u) {
        return scheduleRepository
                .findByListUsersContains(u)
                .stream().map(Schedule::getCourse)
                .collect(Collectors.toList());
    }

    public boolean isUserFull(User user, Map<String, String> params) {
        boolean full = true;
        for (Entry<String, String> entry : params.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    String Name = entry.getValue();
                    if (Name.isEmpty())
                        full = false;
                    /*user.setFullProfile(false);*/
                    break;
                case "surname":
                    String Surname = entry.getValue();
                    if (Surname.isEmpty())
                        full = false;
                    break;
                case "email":
                    String Email = entry.getValue();
                    if (Email.isEmpty())
                        full = false;
                    break;
                case "password":
                    String Password = entry.getValue();
                    if (Password.isEmpty())
                        full = false;
                    break;
                case "age":
                    String Age = entry.getValue();
                    if (Age.isEmpty())
                        full = false;
                    break;
                default:
                    break;
            }
        }
        return full;
    }
    public boolean isUserFull(User user){
        boolean full = true;
        if (user.getName() == null || user.getName().isEmpty())
            full = false;
        if (user.getSurname() == null || user.getSurname().isEmpty())
            full = false;
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty())
            full = false;
        if (user.getAge() == 0)
            full = false;
        if (user.getEmail() == null || user.getEmail().isEmpty())
            full = false;
        if(user.getNickname() == null || user.getNickname().isEmpty())
            full = false;
        return full;
    }

    //Pagination
    public Page<User> findAllusers(PageRequest page) {
        return userRepository.findAll(page);
    }


}
