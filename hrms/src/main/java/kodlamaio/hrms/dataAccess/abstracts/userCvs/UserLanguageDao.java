package kodlamaio.hrms.dataAccess.abstracts.userCvs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCvEntity.UserLanguage;

public interface UserLanguageDao extends JpaRepository<UserLanguage, Integer>{
	List<UserLanguage> getByUserCv_UserCvIdIn(List<Integer> userCvId);
	
}
