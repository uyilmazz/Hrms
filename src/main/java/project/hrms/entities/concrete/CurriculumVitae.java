package project.hrms.entities.concrete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cirriculum_vitae")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name="driver_license")
    private String driverLicense;
	
	@Column(name="profil_image")
    private String profilImage;
	
	@Column(name="over_letter")
	private String overLetter;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<School> schools;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<KnownLanguage> knownLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
