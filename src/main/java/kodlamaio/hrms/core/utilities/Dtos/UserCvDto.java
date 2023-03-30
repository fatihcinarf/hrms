package kodlamaio.hrms.core.utilities.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvDto {

	private List<UserDto> userDtos;
	private String coverLetter;
	private List<String> userAbilitName;
	private List<UserEducationDto> userEducationDtos;
	private List<UserJobExperienceDto> userJobExperiencesDto;
	private List<UserLanguageDto> userLanguagesDtos;
//	private List<UserSocialMediaAccount> userSocialMediaAccounts;


}
