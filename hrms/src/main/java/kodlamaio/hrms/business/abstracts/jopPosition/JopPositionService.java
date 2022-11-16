package kodlamaio.hrms.business.abstracts.jopPosition;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JopPosition;

public interface JopPositionService {
	List<JopPosition> getAllJopPosition();
	
	JopPosition getByJopPositionName(String jopPositionName);
}
