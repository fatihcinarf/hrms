package kodlamaio.hrms.business.concretes.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.employer.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.employer.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService) {
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public DataResult<Employer> addEmployer(Employer employer) {
		if (!employerCheckService.isEmployerAnyEmpty(employer)) {
			return new DataResult<Employer>(null, false, "Değerler boş olamaz...");
		} else if (employerCheckService.existsEmployerEmail(employer.getEmployerEmail())) {
			return new DataResult<Employer>(null, false, "Employer Email kayıtlı olduğu için kaydedilemedi...");
		} else {
			return new SuccessDataResult<Employer>(this.employerDao.save(employer), "Employer Kaydedildi...");
		}
	}

	@Override
	public Employer getByEmployerEmail(String employerEmail) {
		return this.employerDao.getByEmployerEmail(employerEmail);
	}

}
