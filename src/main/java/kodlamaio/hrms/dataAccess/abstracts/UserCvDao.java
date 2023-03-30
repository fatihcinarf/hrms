package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCv;

public interface UserCvDao extends JpaRepository<UserCv, Integer> {

	UserCv getByUserCvId(int userCvId);
	
	List<UserCv> getByUser_UserIdIn(List<Integer> users);
	
	UserCv getAllByUser_UserId(int userCvId);
	
	
}
