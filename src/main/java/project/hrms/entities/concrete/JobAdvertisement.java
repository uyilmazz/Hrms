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

@Entity
@Table(name="job_advertisements")
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

	public JobAdvertisement() {
	}

	public JobAdvertisement(int id, String description, double minSalary, double maxSalary, int openNumberOfPositions,
			Date createdDate, Date deadline,boolean isActive) {
		super();
		this.id = id;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openNumberOfPositions = openNumberOfPositions;
		this.createdDate = createdDate;
		this.deadline = deadline;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getOpenNumberOfPositions() {
		return openNumberOfPositions;
	}

	public void setOpenNumberOfPositions(int openNumberOfPositions) {
		this.openNumberOfPositions = openNumberOfPositions;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
