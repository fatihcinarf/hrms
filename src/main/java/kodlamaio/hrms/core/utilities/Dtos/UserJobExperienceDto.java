package kodlamaio.hrms.core.utilities.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJobExperienceDto {

	private String workplaceName; // İş Yeri Adi

	private String jopPosition;

	private LocalDate startingJobDate;

	private LocalDate dateOfJobGraduation;

}
