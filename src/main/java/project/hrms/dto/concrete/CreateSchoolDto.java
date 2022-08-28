package project.hrms.dto.concrete;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolDto {
	private String name;
	private String department;
	private String beginYear;
	private String endYear;
}
