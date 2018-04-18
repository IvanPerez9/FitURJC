package es.fiturjc.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import es.fiturjc.model.User.Details;

import java.util.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Schedule {
	
	public interface Basic{}
	public interface Details{}
	public interface None{}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private long idSchedule;
	
	@JsonView(Basic.class)
	private String schedule;

    @ManyToMany
    @JsonView(Basic.class)
    private Set<User> listUsers = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(Details.class)
    private Course course;

    @Transient
    @JsonIgnore
	public boolean signup;
	
	private static final long MAXIMUM_CAPACITY = 2;

	@JsonView(Details.class)
	public boolean isFull(){
		return MAXIMUM_CAPACITY <= listUsers.size();
	}


	protected Schedule() {

	}
	
	public long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Schedule(String schedule) {
		super();
		this.schedule = schedule;
	}

	public void addUser(User user) {
		if (listUsers.size() <= MAXIMUM_CAPACITY) {
			if(!listUsers.contains(user)) {
				this.listUsers.add(user);
			}
		}
	}

	public void deleteUser(User user) {
		if(listUsers.contains(user)) {
			this.listUsers.remove(user);
		}
	}
	
	public List<User> getUser() {

		return new ArrayList<>(listUsers);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Schedule schedule = (Schedule) o;
		return idSchedule == schedule.idSchedule;
	}

	@Override
	public int hashCode() {

		return Objects.hash(idSchedule);
	}
}
