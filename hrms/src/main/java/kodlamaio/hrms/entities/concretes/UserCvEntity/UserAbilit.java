
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
@Table(name = "user_abilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAbilit { // Yetenekler

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_abilit_id")
	private int userAbilitId;
	
	@Column(name = "user_abilit_name")
	private String userAbilitName;

	@ManyToOne
	@JoinColumn(name="user_cv_id")
	private UserCv userCv;

}
