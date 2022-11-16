package kodlamaio.hrms.business.abstracts.user;

import kodlamaio.hrms.entities.concretes.User;

public interface UserCheckService {
	
	boolean isUserAnyEmpty(User user);
	boolean existsUserEmail(String userEmail);
	boolean existsTcNo(String tcNo);
	
	//boolean getByUserEmailOrTcNo(String userEmail,String tcNo);
}
