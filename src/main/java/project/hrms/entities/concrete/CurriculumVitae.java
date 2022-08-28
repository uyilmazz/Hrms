package project.hrms.entities.concrete;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cirriculum_vitae")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "gender")
	private String gender;

	@Column(name = "driver_license")
	private String driverLicense;

	@Column(name = "profil_image")
	private String profilImage;

	@Column(name = "over_letter")
	private String overLetter;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name = "cv_id",referencedColumnName="id")
	private List<School> schools;

	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name = "cv_id",referencedColumnName="id")
	private List<JobExperience> jobExperiences;

	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name = "cv_id",referencedColumnName="id")
	private List<KnownLanguage> knownLanguages;

	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name = "cv_id",referencedColumnName="id")
	private List<ProgrammingLanguage> programmingLanguages;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
