package es.fiturjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
