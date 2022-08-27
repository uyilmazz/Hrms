package project.hrms.entities.concrete;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String tcNo;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@OneToMany(mappedBy="candidate")
	private List<CurriculumVitae> curriculumVitaes;
}
