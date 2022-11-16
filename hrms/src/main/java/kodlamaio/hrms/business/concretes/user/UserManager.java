package kodlamaio.hrms.business.concretes.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.user.UserCheckService;
import kodlamaio.hrms.business.abstracts.user.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserCheckService userCheckService;

	@Autowired
	public UserManager(UserDao userDao, UserCheckService userCheckService) {
		this.userDao = userDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public DataResult<User> userAdd(User user) {
		if (userCheckService.isUserAnyEmpty(user)) {
			return new DataResult<User>(null, false, "değerler boş olamaz...");

		} else {

			if (userCheckService.existsTcNo(user.getTcNo()) || userCheckService.existsUserEmail(user.getUserEmail())) {

				if (userCheckService.existsTcNo(user.getTcNo())
						&& userCheckService.existsUserEmail(user.getUserEmail())) {
					return new DataResult<User>(null, false, "TC No ve Email değerleri aynı olamaz...");

				} else if (userCheckService.existsTcNo(user.getTcNo())) {
					return new DataResult<User>(null, false, "TC No değerleri aynı olamaz...");

				} else {
					return new DataResult<User>(null, false, "UserEmail aynı olamaz...");
				}
			} else {
				return new DataResult<User>(this.userDao.save(user), true, "İşlem Başarılı...");
			}
		}
	}

	@Override
	public User getByTcNo(String tcNo) {
		return this.userDao.getByTcNo(tcNo);
	}

	@Override
	public User getByUserEmail(String userEmail) {
		return this.userDao.getByUserEmail(userEmail);
	}

	@Override
	public void deleteByUserName(String tcNo) {
		User user = this.userDao.getByTcNo(tcNo);
		this.userDao.delete(user);
	}
	
	@Override
	public List<User> getByTcNoAndUserEmail(String tcNo, String userEmail) {
		return this.userDao.getByTcNoAndUserEmail(tcNo, userEmail);
	}

	@Override
	public List<User> getByTcNoOrUserEmail(String tcNo, String userEmail) {
		return this.userDao.getByTcNoOrUserEmail(tcNo, userEmail);
	}

	@Override
	public DataResult<User> updateUser(String tcNo, User user) {
		
		User updateUser=this.userDao.getByTcNo(tcNo);
		
		updateUser.setUserName(user.getUserName());
		updateUser.setUserSurname(user.getUserSurname());
		updateUser.setTcNo(user.getTcNo());
		updateUser.setUserEmail(user.getUserEmail());
		updateUser.setUserPassword(user.getUserPassword());
		updateUser.setUserRepeatPassword(user.getUserRepeatPassword());

		return userAdd(updateUser);
	}

}
