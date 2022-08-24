package project.hrms.dto.concrete;

public class CreateCandidateDto {
	
	private String firstName;
	private String lastName;
	private String tcNo;
	private int birthYear;
	private String email;
	private String password;
	private String confirmPassword;
	
	public CreateCandidateDto() {
	}

	public CreateCandidateDto(String firstName, String lastName, String tcNo, int birthYear, String email,
			String password, String confirmPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcNo = tcNo;
		this.birthYear = birthYear;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}	
}


