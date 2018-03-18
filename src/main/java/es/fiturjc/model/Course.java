package es.fiturjc.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.*;

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

import es.fiturjc.model.User.Basic;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id") // Resuelve la circular 
public class Course {
	
	public interface Basic{}
	public interface Details{}
	public interface None{}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private long id;
	
	@JsonView(Details.class)
	private String src;

	@JsonView(Basic.class)
	private String name;
	
	@JsonView(Details.class)
	private Category category;
	
	@JsonView(Details.class)
	private String description;
	//orphanRemoval = true eliminated by errors in the course modification

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="course")
	@JsonView(Details.class)
	private List<Schedule> schedules = new ArrayList<>();
	
//	//DANI
//	@ManyToMany(mappedBy="courseList")
//	private List<User> participants_IDs = new ArrayList<>();
	
	//Json to object
	protected Course() {
	}
	
	public Course(String name, Category category, String description, Schedule... schedules) {
		this(name,category,description,Arrays.asList(schedules));
	}

	public Course(String name, Category category, String description, List<Schedule> schedules) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.schedules = schedules;
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
	
	public void setId(Long id) {
		this.id = id;
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
