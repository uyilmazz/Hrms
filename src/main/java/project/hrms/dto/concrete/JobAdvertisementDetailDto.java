package project.hrms.dto.concrete;

import java.util.Date;

public class JobAdvertisementDetailDto {

	private int id;
	private String companyName;
	private String jobTitle;
	private int openNumberOfPositions;
	private Date createdDate;
	private Date deadline;
	
	public JobAdvertisementDetailDto() {
	}

	public JobAdvertisementDetailDto(int id, String companyName, String jobTitle, int openNumberOfPositions,
			Date createdDate, Date deadline) {
		this.id = id;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.openNumberOfPositions = openNumberOfPositions;
		this.createdDate = createdDate;
		this.deadline = deadline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getNumberOfPositions() {
		return openNumberOfPositions;
	}

	public void setNumberOfPositions(int numberOfPositions) {
		this.openNumberOfPositions = numberOfPositions;
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
}
