package kodlamaio.hrms.business.concretes.jopPosition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jopPosition.JopPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JopPositionDao;
import kodlamaio.hrms.entities.concretes.JopPosition;

@Service
public class JopPositionManager implements JopPositionService{
	private JopPositionDao jopPositionDao;

	@Autowired
	public JopPositionManager(JopPositionDao jopPositionDao) {
		super();
		this.jopPositionDao = jopPositionDao;
	}

	@Override
	public List<JopPosition> getAllJopPosition() {
		return this.jopPositionDao.findAll();
	}

	@Override
	public JopPosition getByJopPositionName(String jopPositionName) {
		return this.jopPositionDao.getByJopPositionName(jopPositionName);
	}

	
	
}
