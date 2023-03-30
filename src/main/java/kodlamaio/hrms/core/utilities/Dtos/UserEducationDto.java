package kodlamaio.hrms.core.utilities.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEducationDto {

	private String schoolName;

	private String schoolDepartment;

	private LocalDate startingDate;

	private LocalDate dateOfGraduation;

}
