package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCvService;
import kodlamaio.hrms.core.utilities.Dtos.UserCvDetailsDto;
import kodlamaio.hrms.core.utilities.Dtos.UserCvDto;
import kodlamaio.hrms.core.utilities.Dtos.UserDto;
import kodlamaio.hrms.core.utilities.Dtos.UserEducationDto;
import kodlamaio.hrms.core.utilities.Dtos.UserJobExperienceDto;
import kodlamaio.hrms.core.utilities.Dtos.UserLanguageDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserCvDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.userCvs.UserAbilitDao;
import kodlamaio.hrms.dataAccess.abstracts.userCvs.UserEducationDao;
import kodlamaio.hrms.dataAccess.abstracts.userCvs.UserJobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.userCvs.UserLanguageDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserCv;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserEducation;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserJobExperience;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserLanguage;

@Service
public class UserCvManager implements UserCvService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserCvDao userCvDao;
	@Autowired
	private UserAbilitDao userAbilitDao;
	@Autowired
	private UserEducationDao userEducationDao;
	@Autowired
	private UserJobExperienceDao userJobExperienceDao;
	@Autowired
	private UserLanguageDao userLanguageDao;

	@Override
	public DataResult<List<UserCv>> getAllUserCv() {
		return new SuccessDataResult<List<UserCv>>(this.userCvDao.findAll(), "işlem başarılı...");
	}

	@Override
	public DataResult<UserCv> addUserCv(UserCv userCv) {
		return new SuccessDataResult<UserCv>(this.userCvDao.save(userCv));
	}

	@Override
	public UserCv getByUserCvId(int userCvId) {
		return this.userCvDao.getByUserCvId(userCvId);
	}

	@Override
	public DataResult<List<UserCv>> getByUser_UserIdIn(List<Integer> users) {
		return new SuccessDataResult<List<UserCv>>(this.userCvDao.getByUser_UserIdIn(users));
	}

	@Override
	public UserAbilit getByUserAbilitId(int userCvId) {
		return this.userAbilitDao.getByUserAbilitId(userCvId);
	}

	@Override
	public List<UserCvDto> getAllUserCvDto() {
		List<UserCvDto> userCvDtos = new ArrayList<>();
		List<Integer> userCvId = new ArrayList<>();
		List<UserCv> userCvs = this.userCvDao.findAll();

		for (int i = 1; i <= userCvs.size(); i++) {
			UserCvDto userCvItem = new UserCvDto();
			UserCv userCv = this.userCvDao.getByUserCvId(i);
			List<String> userAbilitName = new ArrayList<>();

			userCvId.add(i);
			List<UserAbilit> userAbilities = this.userAbilitDao.getByUserCv_UserCvIdIn(userCvId);
			userAbilitName.clear();

			List<User> users = this.userDao.getByUserCv_UserCvIdIn(userCvId);
			List<UserDto> userDtos = new ArrayList<>();
			for (int j = 1; j <= users.size(); j++) {
				UserDto userItem = new UserDto();
				userItem.setUserName(users.get(j - 1).getUserName());
				userItem.setUserSurname(users.get(j - 1).getUserSurname());
				userItem.setUserEmail(users.get(j - 1).getUserEmail());
				userItem.setDataOfBirth(users.get(j - 1).getDataOfBirth());
				userDtos.add(userItem);
				userCvItem.setUserDtos(userDtos);
			}

			userCvItem.setCoverLetter(userCv.getCoverLetter());

			for (int j = 1; j <= userAbilities.size(); j++) {
				userAbilitName.add(userAbilities.get(j - 1).getUserAbilitName());
				userCvItem.setUserAbilitName(userAbilitName);
			}

			List<UserEducation> userEducations = this.userEducationDao.getByUserCv_UserCvIdIn(userCvId);
			List<UserEducationDto> userEducatioDtos = new ArrayList<>();
			for (int j = 1; j <= userEducations.size(); j++) {
				UserEducationDto userEducationItem = new UserEducationDto();
				userEducationItem.setSchoolName(userEducations.get(j - 1).getSchoolName());
				userEducationItem.setSchoolDepartment(userEducations.get(j - 1).getSchoolDepartment());
				userEducationItem.setStartingDate(userEducations.get(j - 1).getStartingDate());
				userEducationItem.setDateOfGraduation(userEducations.get(j - 1).getDateOfGraduation());
				userEducatioDtos.add(userEducationItem);
				userCvItem.setUserEducationDtos(userEducatioDtos);
			}

			List<UserJobExperience> userJobExperiences = this.userJobExperienceDao.getByUserCv_UserCvIdIn(userCvId);
			List<UserJobExperienceDto> userJobExperienceDtos = new ArrayList<>();
			for (int j = 1; j <= userJobExperiences.size(); j++) {
				UserJobExperienceDto userJobExperienceItem = new UserJobExperienceDto();
				userJobExperienceItem.setJopPosition(userJobExperiences.get(j - 1).getJopPosition());
				userJobExperienceItem.setWorkplaceName(userJobExperiences.get(j - 1).getWorkplaceName());
				userJobExperienceItem.setStartingJobDate(userJobExperiences.get(j - 1).getStartingJobDate());
				userJobExperienceItem.setDateOfJobGraduation(userJobExperiences.get(j - 1).getDateOfJobGraduation());
				userJobExperienceDtos.add(userJobExperienceItem);
				userCvItem.setUserJobExperiencesDto(userJobExperienceDtos);
			}

			List<UserLanguage> userLanguages = this.userLanguageDao.getByUserCv_UserCvIdIn(userCvId);
			List<UserLanguageDto> userLanguageDtos = new ArrayList<>();
			for (int j = 1; j <= userLanguages.size(); j++) {
				UserLanguageDto userLanguageItem = new UserLanguageDto();
				userLanguageItem.setLanguageName(userLanguages.get(j - 1).getLanguageName());
				userLanguageItem.setLanguageLevel(userLanguages.get(j - 1).getLanguageLevel());
				userLanguageDtos.add(userLanguageItem);
				userCvItem.setUserLanguagesDtos(userLanguageDtos);
			}

			userCvId.clear();
			userCvDtos.add(userCvItem);
		}
		return userCvDtos;
	}

	@Override
	public UserCv getAllByUser_UserId(int userCvId) {
		return this.userCvDao.getAllByUser_UserId(userCvId);
	}

	@Override
	public UserCvDetailsDto getByUserCvIdDetails(int userCvId) {
		UserCvDetailsDto userCvDetails = new UserCvDetailsDto();
		UserCv userCv=this.userCvDao.getByUserCvId(userCvId);
		
		userCvDetails.setCoverLetter(userCv.getCoverLetter());
		userCvDetails.setUsers(userCv.getUser());	
		userCvDetails.setUserAbilities(userCv.getUserAbilits());
		userCvDetails.setUserEducations(userCv.getUserEducations());
		userCvDetails.setUserLanguages(userCv.getUserLanguages());
		userCvDetails.setUserJobExperiences(userCv.getUserJobExperiences());
		
		return userCvDetails;
	}

	

}
