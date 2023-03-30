package kodlamaio.hrms.core.utilities.Dtos;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDto {

	private String userName;

	private String userSurname;

	private String tcNo;
	
	private LocalDate dataOfBirth;

	private String userEmail;

	private String userPassword;

}

