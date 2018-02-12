package FitURJC.facilities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facilities {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String src;
	
	
	public Facilities() {	
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
	
	
	
	
	
	
	
	
	
	

}
