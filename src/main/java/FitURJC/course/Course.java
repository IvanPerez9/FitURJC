package FitURJC.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private String schedule1;
	private String schedule2;
	
	public Course () {}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchedule1() {
		return schedule1;
	}
	public void setSchedule1(String schedule1) {
		this.schedule1 = schedule1;
	}
	public String getSchedule2() {
		return schedule2;
	}
	public void setSchedule2(String schedule2) {
		this.schedule2 = schedule2;
	}
	public Course(String name, String description, String schedule1, String schedule2) {
		super();
		this.name = name;
		this.description = description;
		this.schedule1 = schedule1;
		this.schedule2 = schedule2;
	}
	
}
