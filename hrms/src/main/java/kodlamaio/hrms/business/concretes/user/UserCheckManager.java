package kodlamaio.hrms.business.concretes.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.user.UserCheckService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService {
	private UserDao userDao;
	// private UserService userService;

	@Autowired
	public UserCheckManager(UserDao userDao) {
		this.userDao = userDao;
		// this.userService = userService;
	}

	@Override
	public boolean isUserAnyEmpty(User user) {
		if (user.getUserName().isEmpty() || user.getUserSurname().isEmpty() || user.getTcNo().isEmpty()
				|| user.getUserEmail().isEmpty() || user.getUserPassword().isEmpty()
				|| user.getUserPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean existsUserEmail(String userEmail) {

		if (this.userDao.getByUserEmail(userEmail) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean existsTcNo(String tcNo) {
		if (this.userDao.getByTcNo(tcNo) == null) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * @Override public boolean getByUserEmailOrTcNo(String userEmail, String tcNo)
	 * { if (this.userDao.getByUserEmailOrTcNo(userEmail, tcNo)==null) { return
	 * false; }else { return true; } }
	 */

	


}
