package es.fiturjc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import es.fiturjc.model.Facilities;
import es.fiturjc.repository.FacilitiesRepository;

@Service
public class FacilitiesService {
	private FacilitiesRepository facilitiesRepository;

	public Page<Facilities> getFacilities() {
		return facilitiesRepository.findAll(new PageRequest(0, 10));
	}

	public Page<Facilities> moreFacilities(int page) {
		return facilitiesRepository.findAll(new PageRequest(page, 10));
	}

}
