package es.fiturjc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSchedule;
	private String schedule;
	
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
	
}
