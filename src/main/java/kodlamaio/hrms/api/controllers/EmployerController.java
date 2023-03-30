package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.MethodArgumentNotValidException;
import kodlamaio.hrms.business.abstracts.employer.EmployerService;
import kodlamaio.hrms.core.utilities.ApiError.ApiError;
import kodlamaio.hrms.core.utilities.Dtos.EmployerSaveDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employercontroller")
@CrossOrigin
public class EmployerController {
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@GetMapping("/getAllEmployer")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}

	@PostMapping("/addEmployer")
	public DataResult<Employer> addEmployer(Employer employer) {
		return this.employerService.addEmployer(employer);
	}

	@GetMapping("/adminApproved")
	public List<Employer> getByAdminApproved(int adminApproved) throws Exception {
		return this.employerService.getByAdminApproved(adminApproved);
	}

	@PutMapping("/updateEmployer")
	public void updateBasvuruDurumu(List<Integer> employerId, int durumu) {
		for (int id : employerId) {
			this.employerService.updateBasvuruDurumu(id, durumu);
		}
	}

	@PostMapping("/addEmployerDto")
	public void addEmployerDto(EmployerSaveDto employerSaveDto) {
		this.employerService.addEmployerDto(employerSaveDto);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exceptions) {
		ApiError error = new ApiError(400, "Validation Error", "/api/employercontroller");
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidations(validationErrors);
		return error;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
		
	/*
	 * {
	 * 
	 * }
	 * 
	 * @GetMapping("/employerEmail") public Employer getByEmployerEmail(String
	 * employerEmail) { return
	 * this.employerService.getByEmployerEmail(employerEmail); }
	 * 
	 * @GetMapping("/existsemail") public boolean existsEmployerEmail(String
	 * employerEmail) { return
	 * this.employerCheckService.existsEmployerEmail(employerEmail); }
	 */

}
