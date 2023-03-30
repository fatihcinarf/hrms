package kodlamaio.hrms.core.utilities.Dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFormDto {

	private String jobDescription;
	
	private int minimumSalary;
	
	private int maximumSalary;
	
	private String qouta;
	
	private String jobPositionName;
	
	private String cityName;
	

	private EmployerSaveDto employerSaveDto;
	
	private Date lastApplicationDate;
}

//	private String companyName;
//	private String website;
//	private String employerEmail;
//	private int adminAproved;

