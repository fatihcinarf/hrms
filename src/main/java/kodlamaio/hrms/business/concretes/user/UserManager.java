package kodlamaio.hrms.business.concretes.user;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.user.UserCheckService;
import kodlamaio.hrms.business.abstracts.user.UserService;
import kodlamaio.hrms.core.utilities.Dtos.UserSaveDto;
import kodlamaio.hrms.core.utilities.enums.Roles;
import kodlamaio.hrms.core.utilities.enums.UserConstants;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserCheckService userCheckService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserManager(UserDao userDao, UserCheckService userCheckService) {
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.passwordEncoder = new BCryptPasswordEncoder();
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
				user.setRole(Roles.USER);
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

		User updateUser = this.userDao.getByTcNo(tcNo);

		updateUser.setUserName(user.getUserName());
		updateUser.setUserSurname(user.getUserSurname());
		updateUser.setTcNo(user.getTcNo());
		updateUser.setUserEmail(user.getUserEmail());
		updateUser.setUserPassword(user.getUserPassword());
		updateUser.setRole(user.getRole());

		return userAdd(updateUser);
	}

	@Override
	public User getByUserId(int userId) {
		return this.userDao.getByUserId(userId);
	}

	@Override
	public ResponseEntity<?> userSaveDto(UserSaveDto userSaveDto) {
		User user = new User();
		User getTcNo = this.userDao.getByTcNo(userSaveDto.getTcNo());
		User getUserEmail = this.userDao.getByUserEmail(userSaveDto.getUserEmail());
		Map<String, String> validationErrors = new HashMap<>();

		String userName = userSaveDto.getUserName();
		String userSurname = userSaveDto.getUserSurname();
		String tcNo = userSaveDto.getTcNo();
		String userEmail = userSaveDto.getUserEmail();
		LocalDate dataOfBirth = userSaveDto.getDataOfBirth();
		String userPassword = userSaveDto.getUserPassword();

		if (userName.isEmpty() || userName.isBlank() || userSurname.isEmpty() || userSurname.isBlank() || tcNo.isEmpty()
				|| tcNo.isBlank() || userEmail.isEmpty() || userEmail.isBlank() || dataOfBirth == null) {
			if (userName.isEmpty() || userName.isBlank()) {
				validationErrors.put("userName", "İsim boş olamaz...");
			}
			if (userSurname.isEmpty() || userSurname.isBlank()) {
				validationErrors.put("userSurname", "Soyisim boş olamaz...");
			}
			if (tcNo.isEmpty() || tcNo.isBlank()) {
				validationErrors.put("tcNo", "TC No boş olamaz...");
			}
			if (userEmail.isEmpty() || userEmail.isBlank()) {
				validationErrors.put("userEmail", "Email boş olamaz...");
			}
			if (dataOfBirth == null) {
				validationErrors.put("dataOfBirth", "Doğum Tarihi boş olamaz...");
			}
			if (userPassword.isEmpty() || userPassword.isBlank()) {
				System.out.println("Şifre Alanı Boş Olamaz...");
				validationErrors.put("userPassword", "Şifre boş olamaz...");
			}
			if (validationErrors.size() > 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
			}
		}
		if (!(getTcNo == null) || !(getUserEmail == null)) {
			if (!(getTcNo == null)) {
				validationErrors.put("tcNo", "TC No Kullanılamaz...");
			}
			if (!(getUserEmail == null)) {
				validationErrors.put("userEmail", "Email Kullanılamaz...");
			}
			if (validationErrors.size() > 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
			}
		}

		user.setUserName(userSaveDto.getUserName());
		user.setUserSurname(userSaveDto.getUserSurname());
		user.setUserEmail(userSaveDto.getUserEmail());
		user.setTcNo(userSaveDto.getTcNo());
		user.setDataOfBirth(userSaveDto.getDataOfBirth());
		String encodePassword = this.passwordEncoder.encode(userSaveDto.getUserPassword());
		user.setUserPassword(encodePassword);
		user.setRole(UserConstants.BASVURU_DURUMU_BEKLIYOR);

		return ResponseEntity.ok(new SuccessDataResult<User>(this.userDao.save(user), "işlem başarılı..."));

	}

}
