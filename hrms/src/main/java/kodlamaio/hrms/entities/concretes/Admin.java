package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;

	@NotBlank
	@Column(name = "admin_name")
	private String adminName;

	@NotBlank
	@Column(name = "admin_surname")
	private String adminSurname;

	@NotBlank
	@Column(name = "admin_password")
	private String adminPassword;

	@NotBlank
	private String adminRepeatPassword;


}
