package project.hrms.dto.concrete;

public class CreateEmployerDto {
	
	private String companyName;
	private String webAddress;
	private String email;
	private String phoneNumber;
	private String password;
	private String confirmPassword;
	
	public CreateEmployerDto() {	
	}

	public CreateEmployerDto(String companyName, String webAddress, String email, String phoneNumber, String password,
			String confirmPassword) {
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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


