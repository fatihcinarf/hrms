package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_posting_forms")
public class JobPostingForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_posting_form_id")
	private int jobPostingFormId;

	@Column(name = "active_posting")
	private boolean activePosting;

	/*
	 * @Column(name = "job_position") private String jobPosition;
	 */

	/*
	 * @Column(name = "job_city") private String jobCity;
	 */

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@Column(name = "qouta")
	private String qouta;

	@Column(name = "job_description") // İş Tanımı
	private String jobDescription;

	@Column(name = "last_application_date") // Son Başvuru Tarihi
	private Date lastApplicationDate;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "jop_position_id")
	private JobPosition jopPosition;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

}
