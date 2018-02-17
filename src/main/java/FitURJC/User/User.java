package FitURJC.User;

import java.util.*;

import javax.persistence.*;

import FitURJC.course.Course;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String nickname;
	private String name;
	private String surname;
	private String passwordHash;
	private String imgSrc;

	@Column(unique = true)
	private String email;

	private int age;
	private String description;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

//	private List<Course> courses;

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void changePassword(String newPassword) {
		this.passwordHash = new BCryptPasswordEncoder().encode(newPassword);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<Course> getCourses() {
//		return new ArrayList<>(this.courses);
//	}

//	public void addCurso(Course curso) {
//		this.courses.add(curso);
//	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", description="
				+ description + "]";

	}

	public User(String name, String surname, int age, String passwordHash, String email, String description,
			String nickname, String... roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.email = email;
		this.age = age;
		this.description = description;
		this.nickname = nickname;
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.imgSrc = "hola";
	}

}
