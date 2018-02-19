package FitURJC.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FitURJC.User.User;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long>{

	// Find by ID , y nombre 

}
