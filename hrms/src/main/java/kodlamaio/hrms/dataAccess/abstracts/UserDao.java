package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByTcNo(String tcNo);

	User getByUserEmail(String userEmail);
	
	List<User> getByTcNoAndUserEmail(String tcNo, String userEmail);
	
	List<User> getByTcNoOrUserEmail(String tcNo, String userEmail);
	
	DataResult<User> getByUserName(String userName);
	
	//public User getByUserName(String userName);
	
	//public User getByUserSurname(String userSurname);
	
	
}
