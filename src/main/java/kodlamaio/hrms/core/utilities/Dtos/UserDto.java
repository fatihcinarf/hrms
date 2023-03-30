package kodlamaio.hrms.core.utilities.Dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String userName;

	private String userSurname;

	private LocalDate dataOfBirth;

	private String userEmail;



}
