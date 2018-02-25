
package es.fiturjc.repository;

import es.fiturjc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule, Long>{

	public List<Schedule> findByListUsersContains(User u);


}
