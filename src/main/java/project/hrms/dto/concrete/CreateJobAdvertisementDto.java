package project.hrms.dto.concrete;

import java.sql.Date;

public class CreateJobAdvertisementDto {
	
    private int cityId;
    private int employerId;
    private int jobTitleId;
    private String description;
    private int minSalary;
    private int maxSalary;
    private Date deadline;
    private int openNumberOfPositions;
    private boolean isActive;
    
    public CreateJobAdvertisementDto() {
    }

	public CreateJobAdvertisementDto(int jobTitleId, int cityId, int employerId, String description, int minSalary,
			int maxSalary, Date deadline, int openNumberOfPositions, boolean isActive) {
		this.jobTitleId = jobTitleId;
		this.cityId = cityId;
		this.employerId = employerId;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.deadline = deadline;
		this.openNumberOfPositions = openNumberOfPositions;
		this.isActive = isActive;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(int jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getOpenNumberOfPositions() {
		return openNumberOfPositions;
	}

	public void setOpenNumberOfPositions(int openNumberOfPositions) {
		this.openNumberOfPositions = openNumberOfPositions;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
