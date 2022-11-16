package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name="company_name")
	private String companyName;

	@Column(name = "employer_website" )
	private String website;

	@Column(name = "employer_email")
	private String employerEmail;
	
	@Column(name = "employer_phone")
	private String employerPhone;

	@Column(name = "employer_password")
	private String employerPassword;

	private String employerRepeatPassword;
	
	

}
