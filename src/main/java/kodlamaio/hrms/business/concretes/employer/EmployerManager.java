package kodlamaio.hrms.business.concretes.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.employer.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.employer.EmployerService;
import kodlamaio.hrms.core.utilities.Dtos.EmployerSaveDto;
import kodlamaio.hrms.core.utilities.enums.UserConstants;
import kodlamaio.hrms.core.utilities.results.DataResult;
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

	public void updateBasvuruDurumu(int employerId, int durumu) {
		Employer employer = this.employerDao.findById(employerId).orElse(null);
		employer.setAdminApproved(durumu);
		this.employerDao.save(employer);
	}

	@Override
	public DataResult<Employer> addEmployer(Employer employer) {
		if (employerCheckService.isEmployerAnyEmpty(employer)) {
			return new DataResult<Employer>(null, false, "Değerler boş olamaz...");
		} else if (employerCheckService.existsEmployerEmail(employer.getEmployerEmail())) {
			return new DataResult<Employer>(null, false, "Employer Email kayıtlı olduğu için kaydedilemedi...");
		} else {
			employer.setAdminApproved(UserConstants.BASVURU_DURUMU_BEKLIYOR);
			return new DataResult<Employer>(this.employerDao.save(employer), true);
		}
	}

	@Override
	public Employer getByEmployerEmail(String employerEmail) {
		return this.employerDao.getByEmployerEmail(employerEmail);
	}

	@Override
	public List<Employer> getByAdminApproved(int adminApproved) throws Exception {
		if (adminApproved == UserConstants.BASVURU_DURUMU_BEKLIYOR) {
			return this.employerDao.findAllByAdminApproved(UserConstants.BASVURU_DURUMU_BEKLIYOR);
		} else if (adminApproved == UserConstants.BASVURU_DURUMU_ONAYLI) {
			return this.employerDao.findAllByAdminApproved(UserConstants.BASVURU_DURUMU_ONAYLI);
		} else if (adminApproved == UserConstants.BASVURU_DURUMU_ONAYSIZ) {
			throw new Exception("ONAYSIZLARI GORUTULEYEMEZSINIZ!");
			// this.employerDao.findAllByAdminApproved(UserConstants.BASVURU_DURUMU_ONAYSIZ);
		} else {
			return null;
		}
	}

	@Override
	public void addEmployerDto(EmployerSaveDto employerSaveDto) {
		Employer employer =new Employer();
		
		employer.setCompanyName(employerSaveDto.getCompanyName());
		employer.setWebsite(employerSaveDto.getWebsite());
		employer.setEmployerEmail(employerSaveDto.getEmployerEmail());
		employer.setAdminApproved(UserConstants.BASVURU_DURUMU_BEKLIYOR);
		
		this.employerDao.save(employer);
	}	
		
}
