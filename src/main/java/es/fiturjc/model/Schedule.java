package es.fiturjc.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Schedule {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSchedule;
	private String schedule;

	@ManyToMany
	private Set<User> listUsers = new HashSet<>();



    @ManyToOne(cascade=CascadeType.ALL)
    Course course;


	protected Schedule() {
		
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

	public void annadirUsuario(User user){
		this.listUsers.add(user);
	}

	public void borrarUsuario(User user){
		this.listUsers.remove(user);
	}
	public List<User> dameUsuarios(){

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return idSchedule == schedule.idSchedule;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSchedule);
    }
}
