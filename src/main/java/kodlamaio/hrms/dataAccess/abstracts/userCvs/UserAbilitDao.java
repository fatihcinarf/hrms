package kodlamaio.hrms.dataAccess.abstracts.userCvs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;

public interface UserAbilitDao extends JpaRepository<UserAbilit, Integer> {
	UserAbilit getByUserAbilitId(int userAbilitId);
	 	
	List<UserAbilit> getByUserCv_UserCvIdIn(List<Integer> userCvId);

}
