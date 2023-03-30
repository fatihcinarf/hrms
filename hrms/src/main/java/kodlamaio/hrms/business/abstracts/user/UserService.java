package kodlamaio.hrms.business.abstracts.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.core.utilities.Dtos.UserSaveDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
	
	ResponseEntity<?> userSaveDto(UserSaveDto userSaveDto);

	User getByUserId(int userId);

	DataResult<User> userAdd(User user);

	User getByTcNo(String tcNo);

	User getByUserEmail(String userEmail);

	List<User> getByTcNoAndUserEmail(String tcNo, String userEmail);
	
	List<User> getByTcNoOrUserEmail(String tcNo, String userEmail);

	void deleteByUserName(String tcNo);

	DataResult<User> updateUser(String tcNo, User user);

}

