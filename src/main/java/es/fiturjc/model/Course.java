package es.fiturjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String src;
	private String name;
	private Category category;
	private String description;
	private String schedule1;
	private String schedule2;

	protected Course() {
	}

	public Course(String name, Category category, String description, String schedule1, String schedule2) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.schedule1 = schedule1;
		this.schedule2 = schedule2;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course c1 = (Course) obj;
			return this.category.equals(c1.category);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", schedule1=" + schedule1
				+ ", schedule2=" + schedule2 + ", category=" + category + "]";
	}

}
