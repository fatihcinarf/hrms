
package kodlamaio.hrms.entities.concretes.UserCvEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlamaio.hrms.entities.concretes.UserCv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "user_social_media_accounts")

@Data

@AllArgsConstructor

@NoArgsConstructor
public class UserSocialMediaAccount {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "user_social_media_account_id")
	private int userSocialMediaAccountId;

	@Column(name = "social_media_account")
	private String socialMediaAccount;

	@ManyToOne
	@JoinColumn(name = "user_cv_id")
	private UserCv userCv;
}
