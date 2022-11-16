package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminService;
import kodlamaio.hrms.dataAccess.abstracts.AdminDao;

@Service
public class AdminManager implements AdminService {
	private AdminDao adminDao;
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		this.adminDao=adminDao;
	}
	
}
