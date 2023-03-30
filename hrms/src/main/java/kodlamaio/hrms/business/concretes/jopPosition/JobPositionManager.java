package kodlamaio.hrms.business.concretes.jopPosition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jopPosition.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	private JobPositionDao jopPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jopPositionDao) {
		super();
		this.jopPositionDao = jopPositionDao;
	}

	@Override
	public List<JobPosition> getAllJopPosition() {
		return this.jopPositionDao.findAll();
	}

	@Override
	public JobPosition getByJopPositionName(String jopPositionName) {
		return this.jopPositionDao.getByJopPositionName(jopPositionName);
	}

	
	
}
