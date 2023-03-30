
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

@Table(name = "users_languages")

@Data

@AllArgsConstructor

@NoArgsConstructor
public class UserLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_language_id")
	private int userLanguageId;

	@Column(name = "language_name")
	private String languageName;

	@Column(name = "language_level")
	private int LanguageLevel;

	@ManyToOne
	@JoinColumn(name = "user_cv_id")
	private UserCv userCv;

}
