package es.fiturjc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import es.fiturjc.model.Facilities;

@Repository
public interface FacilitiesRepository extends PagingAndSortingRepository<Facilities, Long> {
	Page<Facilities> findAll(Pageable pageable);

}
