package kodlamaio.hrms.core.utilities.Dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserEducation;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserJobExperience;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvDetailsDto {
	private User users;
	private String coverLetter;
	private List<UserAbilit> userAbilities;
	private List<UserEducation> userEducations;
	private List<UserJobExperience> userJobExperiences;
	private List<UserLanguage> userLanguages;

}
