package project.hrms.dto.concrete;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCurriculumVitaeDto {

	private String gender;
	private String driverLicense;
	private String profilImage;
	private String overLetter;
	private String githubAddress;
	private String linkedinAddress;
	private List<CreateSchoolDto> createSchoolDto;
	private List<CreateJobExperienceDto> createJobExperience;
	private List<CreateKnownLanguageDto> createKnownLanguageDto;
	private List<CreateProgrramingLanguageDto> createProgrramingLanguageDtos;
	private int candidateId;
	
}
