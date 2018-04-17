package es.fiturjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Facilities {

	public interface Basic{}
	public interface Details{}
	public interface None{}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private long id;

	@JsonView(Details.class)
	private String src;

	@JsonView(Details.class)
	private List<Facilities> schedules = new ArrayList<>();

	public Facilities(long id, String src) {
		this.id = id;
		this.src = src;
	}

	protected Facilities() {
	}

	public Facilities(String src) {
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "Facilities [id=" + id + ", src=" + src + ".]" ;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Facilities> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Facilities> schedules) {
		this.schedules = schedules;
	}
}
