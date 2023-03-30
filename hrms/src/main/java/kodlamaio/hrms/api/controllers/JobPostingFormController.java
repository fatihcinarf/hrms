package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.Dtos.JobPostingFormDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

@RestController
@RequestMapping("/api/JobPostingForm")
@CrossOrigin
public class JobPostingFormController {

	private JobPostingFormService jobPostingFormService;

	@Autowired
	public JobPostingFormController(JobPostingFormService jobPostingFormService) {
		this.jobPostingFormService = jobPostingFormService;
	}

	@PostMapping("/createJopPostingFormDto")
	public DataResult<JobPostingForm> createJobPostingDto(@RequestBody JobPostingFormDto jobPostingFormDto) {
		this.jobPostingFormService.createJobPostingForm(jobPostingFormDto);
		return new SuccessDataResult<>("işlem başarılı...");
	}

	@GetMapping("/getAllJopPostingForm")
	public List<JobPostingForm> getAllJopPostingForm() {
		return this.jobPostingFormService.getAllJobPostingForm();
	}

	@PostMapping("/addJopPostingForm")
	public JobPostingForm addJopPostingForm(@RequestBody JobPostingForm jobPostingForm) {
		return this.jobPostingFormService.addJopPostingForm(jobPostingForm);
	}

	@GetMapping("/getByActivePosting")
	public List<JobPostingForm> getByActivePosting(@RequestParam boolean activePosting) {
		return this.jobPostingFormService.getByActivePosting(activePosting);
	}

	/*
	 * @GetMapping("/getByJobCityOrderByLastApplicationDateAsc--------(bir şehirdeki iş ilanını tarihe göre sıralar)"
	 * ) public List<JobPostingForm>
	 * getByJobCityOrderByLastApplicationDateAsc(@RequestParam String jobCity) {
	 * return
	 * this.jobPostingFormService.getByJobCityOrderByLastApplicationDateAsc(jobCity)
	 * ; }
	 */

	@GetMapping("/getByEmployer_CompanyNameAndActivePosting")
	public List<JobPostingForm> getByEmployer_CompanyNameAndActivePosting(@RequestParam String companyName,
			@RequestParam boolean activePosting) {
		return this.jobPostingFormService.getByEmployer_CompanyNameAndActivePosting(companyName, activePosting);
	}

	@GetMapping("/getByJobPostingFormId")
	public DataResult<JobPostingForm> getByJobPostingFormId(@RequestParam int jobPostingFormId) {
		return this.jobPostingFormService.getByJobPostingFormId(jobPostingFormId);
	}

	@GetMapping("/findAllByEmployer_CompanyName")
	public List<JobPostingForm> findAllByEmployer_CompanyName(String companyName) {
		return this.jobPostingFormService.findAllByEmployer_CompanyName(companyName);
	}

	@GetMapping("/getByJobPostingFormIdAndEmployer_CompanyName")
	public JobPostingForm getByJobPostingFormIdAndEmployer_CompanyName(int jobPostingFormId, String companyName) {
		return this.jobPostingFormService.getByJobPostingFormIdAndEmployer_CompanyName(jobPostingFormId, companyName);
	}

}
