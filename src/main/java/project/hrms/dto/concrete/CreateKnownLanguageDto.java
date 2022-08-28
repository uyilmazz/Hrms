package project.hrms.dto.concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateKnownLanguageDto {

	private String name;
	private int level;

}
