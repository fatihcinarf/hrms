package kodlamaio.hrms.business.concretes.jopPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jopPosition.CheckJobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;

@Service
public class CheckJobPositionManager implements CheckJobPositionService {

	private JobPositionDao jopPositionDao;

	@Autowired
	public CheckJobPositionManager(JobPositionDao jopPositionDao) {
		super();
		this.jopPositionDao = jopPositionDao;
	}

	@Override
	public boolean existsJopPosition(String jopPositionName) {
		if (jopPositionDao.getByJopPositionName(jopPositionName) == null) {
			return false;
		} else {
			return true;
		}
	}

}
