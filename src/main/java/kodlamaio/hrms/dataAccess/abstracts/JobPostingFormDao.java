package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {
	
	List<JobPostingForm> findAllByEmployer_CompanyName(String companyName);
	
	List<JobPostingForm> getByActivePosting(boolean activePosting);

	//List<JobPostingForm> getByJobCityOrderByLastApplicationDateAsc(String jobCity);

	List<JobPostingForm> getByEmployer_CompanyNameAndActivePosting(String companyName, boolean activePosting);

	JobPostingForm getByJobPostingFormId(int jobPostingFormId);
	
	JobPostingForm getByJobPostingFormIdAndEmployer_CompanyName(int jobPostingFormId, String companyName);
	

	
}
