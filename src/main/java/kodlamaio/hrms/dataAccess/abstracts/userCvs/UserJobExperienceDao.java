package kodlamaio.hrms.dataAccess.abstracts.userCvs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCvEntity.UserJobExperience;

public interface UserJobExperienceDao extends JpaRepository<UserJobExperience, Integer>{
	List<UserJobExperience> getByUserCv_UserCvIdIn(List<Integer> userCvId);
	
}
