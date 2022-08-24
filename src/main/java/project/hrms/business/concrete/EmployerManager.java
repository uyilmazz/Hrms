package project.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dto.concrete.CreateEmployerDto;
import project.hrms.entities.concrete.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(CreateEmployerDto createEmployerDto) {
		Result validateResult = this.validate(createEmployerDto);
		if(!validateResult.isSuccess()) return validateResult;
		
		Result isExistsResult = this.isExists(createEmployerDto);
		if(!isExistsResult.isSuccess()) return isExistsResult;
		
		Employer employer = new Employer();
		employer.setCompanyName(createEmployerDto.getCompanyName());
		employer.setEmail(createEmployerDto.getEmail());
		employer.setPassword(createEmployerDto.getPassword());
		employer.setPhoneNumber(createEmployerDto.getPhoneNumber());
		employer.setWebAddress(createEmployerDto.getWebAddress());

		this.employerDao.save(employer);
		
		// Send Mail verification code
		return new SuccessResult("Employer added.");
	}
	
	private Result validate(CreateEmployerDto createEmployerDto) {
		if(createEmployerDto.getCompanyName()==null) return new ErrorResult("Company name is required");
		if(createEmployerDto.getEmail()==null) return new ErrorResult("Email is required");
		if(createEmployerDto.getWebAddress() == null) return new ErrorResult("Web address is required");
		if(createEmployerDto.getEmail() == createEmployerDto.getWebAddress()) return new ErrorResult("Web address and email not match");
		if(createEmployerDto.getPassword() == null) new ErrorResult("Passsword is required");
		if(createEmployerDto.getConfirmPassword() == null) new ErrorResult("Confirm password is required");
		if(createEmployerDto.getPassword() != createEmployerDto.getConfirmPassword()) new ErrorResult("Passsword and Confirm password not match");
		if(createEmployerDto.getPhoneNumber() == null) return new ErrorResult("Phone Number is required");
		
		return new SuccessResult();
	}
	
	private Result isExists(CreateEmployerDto createEmployerDto) {
		if(this.employerDao.findByEmail(createEmployerDto.getEmail()) != null) 
			return new ErrorResult("Employer is already exists!");
		
		return new SuccessResult();
	}

	@Override
	public DataResult<Employer> getById(int employerId) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(employerId));
	}

	
	
	
}
