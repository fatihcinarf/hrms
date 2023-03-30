package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserEducation;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserJobExperience;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserLanguage;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserSocialMediaAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_cv")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_cv_id")
	private int userCvId;

	@Column(name = "cover_letter") // ön yazı
	private String coverLetter;

	@OneToMany(mappedBy = "userCv")
	@JsonIgnore
	private List<UserAbilit> userAbilits;

	@OneToMany(mappedBy = "userCv")
	@JsonIgnore
	private List<UserEducation> userEducations;
	
	@OneToMany(mappedBy = "userCv")
	@JsonIgnore
	private List<UserJobExperience> userJobExperiences ;
	
	@OneToMany(mappedBy = "userCv")
	@JsonIgnore
	private List<UserLanguage>  userLanguages;
	
	@OneToMany(mappedBy = "userCv")
	@JsonIgnore
	private List<UserSocialMediaAccount> userSocialMediaAccounts;

	@OneToOne(mappedBy = "userCv")
	private User user;
	
	
	
	
	
	
	
//	@ElementCollection
//	@CollectionTable(name = "listOfUsersCv", 
//						joinColumns = @JoinColumn(name = "user_cv_id"))
//	private List<String> userEducations;
//
//	@Column(name = "user_job_experiences") // iş tecrübesi
//	private List<String> UserJobExperiences;
//
//	@Column(name = "user_languages") // diller
//	private List<String> userLanguages;
//
//	@Column(name = "user_social_media_accounts") // sosyal medyalar
//	private List<String> userSocialMediaAccounts;
}
