package project.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="begin_year")
	private String beginYear;
	
	@Column(name="end_year")
	private String endYear;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CurriculumVitae curriculumVitae;
}
