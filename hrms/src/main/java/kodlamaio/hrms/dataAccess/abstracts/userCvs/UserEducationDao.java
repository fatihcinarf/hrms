package kodlamaio.hrms.dataAccess.abstracts.userCvs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserCvEntity.UserEducation;

public interface UserEducationDao extends JpaRepository<UserEducation, Integer> {
	UserEducation getByUserEducationId(int userEducationId);

	List<UserEducation> getByUserCv_UserCvIdIn(List<Integer> userCvId);

}
