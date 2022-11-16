package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.employer.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.employer.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/employercontroller")
public class EmployerController {
	private EmployerService employerService;
	private EmployerCheckService employerCheckService;

	@Autowired
	public EmployerController(EmployerService employerService, EmployerCheckService employerCheckService) {
		this.employerService = employerService;
		this.employerCheckService = employerCheckService;
	}

	@GetMapping("/getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}

	@GetMapping("/employerEmail")
	public Employer getByEmployerEmail(String employerEmail) {
		return this.employerService.getByEmployerEmail(employerEmail);
	}

	@GetMapping("/existsemail")
	public boolean existsEmployerEmail(String employerEmail) {
		return this.employerCheckService.existsEmployerEmail(employerEmail);
	}

	@PostMapping("/addEmployer")
	public DataResult<Employer> addEmployer(Employer employer) {
		return this.employerService.addEmployer(employer);
	}

}
