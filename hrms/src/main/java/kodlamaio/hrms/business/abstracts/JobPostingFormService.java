package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.Dtos.JobPostingFormDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormService {

	List<JobPostingForm> getAllJobPostingForm();

	List<JobPostingForm> findAllByEmployer_CompanyName(String companyName);

	JobPostingForm addJopPostingForm(JobPostingForm jobPostingForm);

	List<JobPostingForm> getByActivePosting(boolean activePosting);

	//List<JobPostingForm> getByJobCityOrderByLastApplicationDateAsc(String jobCity);

	List<JobPostingForm> getByEmployer_CompanyNameAndActivePosting(String companyName, boolean activePosting);

	DataResult<JobPostingForm> getByJobPostingFormId(int jobPostingFormId);

	JobPostingForm getByJobPostingFormIdAndEmployer_CompanyName(int jobPostingFormId, String companyName);

	void createJobPostingForm(JobPostingFormDto jobPostingFormDto);

}
