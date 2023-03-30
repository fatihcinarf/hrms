
package kodlamaio.hrms.entities.concretes.UserCvEntity;

import java.time.LocalDate;

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

//İŞ TECRÜBESİ

@Entity
@Table(name = "users_jop_experience")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJobExperience { // Kulanıcı İş Deneyimi

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_jop_experience_id")
	private int userJopExperienceId;

	@Column(name = "workplace_name")
	private String workplaceName; // İş Yeri Adi

	@Column(name = "jop_position")
	private String jopPosition;

	@Column(name = "starting_job_date")
	private LocalDate startingJobDate;

	@Column(name = "date_of_job_graduation")
	private LocalDate dateOfJobGraduation;

	@ManyToOne
	@JoinColumn(name = "user_cv_id")
	private UserCv userCv;

}
