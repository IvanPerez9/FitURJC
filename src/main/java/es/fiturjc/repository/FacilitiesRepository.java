package es.fiturjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Facilities;

@Repository
public interface FacilitiesRepository extends JpaRepository <Facilities, Long>{

	
}
