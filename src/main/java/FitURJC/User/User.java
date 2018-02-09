package FitURJC.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nickname;
	private String name;
	private String surname;
	private int age;
	private String description;

	public User () {}
	
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

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", description="
				+ description + "]";
	}

	public User(String name, String surname, int age, String description, String nickname) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.description = description;
		this.nickname = nickname;
	}

}
