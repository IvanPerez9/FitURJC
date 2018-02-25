package es.fiturjc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

/*	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Course> courses = new ArrayList<Course>();*/

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

/*	public List<Course> getCourses() {
		return new ArrayList<>(this.courses);
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}*/

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + " ]";

	}
	

	public User(String name, String surname, int age, String passwordHash, String email,
			String nickname, String... roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.email = email;
		this.age = age;
		this.nickname = nickname;
		this.roles = new ArrayList<>(Arrays.asList(roles));
		this.imgSrc = "/uploads/img/default";
	}

}
