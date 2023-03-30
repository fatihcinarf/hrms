
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

@Entity
@Table(name = "users_Education")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_education_id")
	private int userEducationId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "school_department") // okul bölümü
	private String schoolDepartment;

	@Column(name = "starting_date") // başlangıç tarihi
	private LocalDate startingDate;

	@Column(name = "date_of_graduation") // mezuniyet tarihi
	private LocalDate dateOfGraduation;

	@ManyToOne
	@JoinColumn(name = "user_cv_id")
	private UserCv userCv;

}
