package kodlamaio.hrms.core.utilities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerSaveDto {
	
	private String companyName;
	
	private String website;
	
	private String employerEmail;
	
	
}
