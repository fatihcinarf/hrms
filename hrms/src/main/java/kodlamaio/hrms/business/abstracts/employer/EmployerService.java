package kodlamaio.hrms.business.abstracts.employer;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	public List<Employer> getAll();
	
	DataResult<Employer> addEmployer(Employer employer);
	
	Employer getByEmployerEmail(String employerEmail);
}
