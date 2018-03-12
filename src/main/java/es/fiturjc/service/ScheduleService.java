package es.fiturjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fiturjc.model.Schedule;
import es.fiturjc.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	public Schedule findById (long id) {
		return scheduleRepository.findOne(id);
	}
	
}
