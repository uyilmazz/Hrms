package project.hrms.dto.concrete;

public class CreateJobTitleDto {
	
	private String title;
	
	public CreateJobTitleDto() {
	}
	
	public CreateJobTitleDto(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
