package kodlamaio.hrms.business.concretes.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.employer.EmployerCheckService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public boolean existsEmployerEmail(String employerEmail) {
		if (this.employerDao.getByEmployerEmail(employerEmail) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEmployerAnyEmpty(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getEmployerEmail().isEmpty()||
			employer.getEmployerPassword().isEmpty() || employer.getEmployerPhone().isEmpty()|| 
			employer.getWebsite().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkAdminApproved(Employer employer) {
		return false;
	}

}
