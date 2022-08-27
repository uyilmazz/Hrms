package project.hrms.entities.concrete;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="job_title_id")
	@ManyToOne()
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_number_of_positions")
	private int openNumberOfPositions;
	
	@CreationTimestamp
	@Column(name="created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	@Column(name="deadline")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;	
}
