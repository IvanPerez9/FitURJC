package es.fiturjc.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String src;
	private String name;
	private Category category;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy="course")
	private List<Schedule> schedules = new ArrayList<Schedule>();
	
	//DANI
	@ManyToMany(mappedBy="courseList")
	private List<User> participants_IDs = new ArrayList<>();
	
	protected Course() {
		
	}

	public Course(String name, Category category, String description, int capacity, Schedule... schedules) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.schedules = Arrays.asList(schedules);
	}

	public long getId() {
		return id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
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


	public void addSchedule (Schedule schedule) {
		this.schedules.add(schedule);
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", src=" + src + ", name=" + name + ", category=" + category + ", description="
				+ description + ", schedules=" + schedules + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
