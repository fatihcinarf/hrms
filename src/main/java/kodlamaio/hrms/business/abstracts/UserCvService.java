package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.Dtos.UserCvDetailsDto;
import kodlamaio.hrms.core.utilities.Dtos.UserCvDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserCv;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;

public interface UserCvService {
	
	DataResult<List<UserCv>> getAllUserCv();

	DataResult<UserCv> addUserCv(UserCv userCv);
	
	UserCv getByUserCvId(int userCvId);

	UserCvDetailsDto getByUserCvIdDetails(int userCvId);

	UserAbilit getByUserAbilitId(int userCvId);

	DataResult<List<UserCv>> getByUser_UserIdIn(List<Integer> users);
	
	UserCv getAllByUser_UserId(int userCvId);
	
	List<UserCvDto> getAllUserCvDto();
	
}
