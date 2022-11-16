package kodlamaio.hrms.business.concretes.jopPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jopPosition.CheckJopPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JopPositionDao;

@Service
public class CheckJopPositionManager implements CheckJopPositionService {

	private JopPositionDao jopPositionDao;

	@Autowired
	public CheckJopPositionManager(JopPositionDao jopPositionDao) {
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
