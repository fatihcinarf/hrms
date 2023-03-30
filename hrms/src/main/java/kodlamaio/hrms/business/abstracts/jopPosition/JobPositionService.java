package kodlamaio.hrms.business.abstracts.jopPosition;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAllJopPosition();
	
	JobPosition getByJopPositionName(String jopPositionName);
}
