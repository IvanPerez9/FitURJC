package es.fiturjc.repository;

import es.fiturjc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Course;


import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
    public List<Course> findByCategory(Category category);
    
    public List<Course> findByName(String name);

    Course findById(long id);


}
