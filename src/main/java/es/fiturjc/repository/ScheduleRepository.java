
package es.fiturjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule, Long>{
	
	
}
