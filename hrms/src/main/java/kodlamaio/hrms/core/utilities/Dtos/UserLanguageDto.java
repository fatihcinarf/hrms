package kodlamaio.hrms.core.utilities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLanguageDto {
	
	private String languageName;

	private int LanguageLevel;
}
