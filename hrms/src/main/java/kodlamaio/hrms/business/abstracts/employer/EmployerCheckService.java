package kodlamaio.hrms.business.abstracts.employer;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerCheckService {	
	boolean isEmployerAnyEmpty(Employer employer);
	boolean existsEmployerEmail(String employerEmail);
	
	
}
