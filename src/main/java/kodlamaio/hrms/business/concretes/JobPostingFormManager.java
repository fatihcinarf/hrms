package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.Dtos.JobPostingFormDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingFormDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

@Service
public class JobPostingFormManager implements JobPostingFormService {

	private JobPostingFormDao jobPostingFormDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;
	private CityDao cityDao;

	@Autowired
	public JobPostingFormManager(JobPostingFormDao jobPostingFormDao, EmployerDao employerDao,
			JobPositionDao jobPositionDao, CityDao cityDao) {
		this.jobPostingFormDao = jobPostingFormDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.cityDao = cityDao;
	}

	@Override
	public List<JobPostingForm> getAllJobPostingForm() {
		return this.jobPostingFormDao.findAll();
	}

	@Override
	public JobPostingForm addJopPostingForm(JobPostingForm jobPostingForm) {
		return this.jobPostingFormDao.save(jobPostingForm);
	}

	@Override
	public List<JobPostingForm> getByActivePosting(boolean activePosting) {
		return this.jobPostingFormDao.getByActivePosting(activePosting);
	}

	/*
	 * @Override public List<JobPostingForm>
	 * getByJobCityOrderByLastApplicationDateAsc(String jobCity) { return
	 * this.jobPostingFormDao.getByJobCityOrderByLastApplicationDateAsc(jobCity); }
	 */

	@Override
	public List<JobPostingForm> getByEmployer_CompanyNameAndActivePosting(String companyName, boolean activePosting) {
		return this.jobPostingFormDao.getByEmployer_CompanyNameAndActivePosting(companyName, activePosting);
	}

	@Override
	public DataResult<JobPostingForm> getByJobPostingFormId(int jobPostingFormId) {
		return new SuccessDataResult<JobPostingForm>(this.jobPostingFormDao.getByJobPostingFormId(jobPostingFormId));
	}

	@Override
	public List<JobPostingForm> findAllByEmployer_CompanyName(String companyName) {
		return this.jobPostingFormDao.findAllByEmployer_CompanyName(companyName);
	}

	@Override
	public JobPostingForm getByJobPostingFormIdAndEmployer_CompanyName(int jobPostingFormId, String companyName) {
		JobPostingForm form = this.jobPostingFormDao.getByJobPostingFormIdAndEmployer_CompanyName(jobPostingFormId,
				companyName);

		form.setActivePosting(false);
		return this.jobPostingFormDao.save(form);

	}

	@Override
	public void createJobPostingForm(JobPostingFormDto jobPostingFormDto) {
		JobPostingForm jobPostingForm = new JobPostingForm();
		Employer employer = new Employer();

		// JobPosition jobPosition
		// =this.jobPositionDao.getByJopPositionName(jobPostingFormDto.getJobPositionName());

		jobPostingForm.setJobDescription(jobPostingFormDto.getJobDescription());
		jobPostingForm.setMinimumSalary(jobPostingFormDto.getMinimumSalary());
		jobPostingForm.setMaximumSalary(jobPostingFormDto.getMaximumSalary());
		jobPostingForm.setQouta(jobPostingFormDto.getQouta());
		jobPostingForm.setLastApplicationDate(jobPostingFormDto.getLastApplicationDate());

		JobPosition jobPosition = jobPositionDao.getByJopPositionName(jobPostingFormDto.getJobPositionName());
		jobPostingForm.setJopPosition(jobPosition);
		jobPostingForm.getJopPosition().setJopPositionId(jobPosition.getJopPositionId());

		City city = this.cityDao.getByCityName(jobPostingFormDto.getCityName());
		jobPostingForm.setCity(city);
		jobPostingForm.getCity().setCityId(jobPostingForm.getCity().getCityId());

		employer.setCompanyName(jobPostingFormDto.getEmployerSaveDto().getCompanyName());
		employer.setWebsite(jobPostingFormDto.getEmployerSaveDto().getWebsite());
		employer.setEmployerEmail(jobPostingFormDto.getEmployerSaveDto().getEmployerEmail());

		this.employerDao.save(employer);

		jobPostingForm.setEmployer(employer);
		jobPostingForm.getEmployer().setEmployerId(employer.getEmployerId());

		this.jobPostingFormDao.save(jobPostingForm);

	}

}
