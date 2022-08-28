package project.hrms.business.concrete;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.dto.concrete.CreateCandidateDto;
import project.hrms.entities.concrete.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}
	
	@Override
	public Result add(CreateCandidateDto createCandidateDto) {
		Result validateResult = validate(createCandidateDto);
		if(!validateResult.isSuccess()) {
			return validateResult;
		}
		
		// mernis validation 
		
		Result isExistsResult = this.isExists(createCandidateDto);
		if(!isExistsResult.isSuccess()) {
			return isExistsResult;
		}
		
		Candidate candidate = new Candidate();
		candidate.setFirstName(createCandidateDto.getFirstName());
		candidate.setLastName(createCandidateDto.getLastName());
		candidate.setEmail(createCandidateDto.getEmail());
		candidate.setPassword(createCandidateDto.getPassword());
		candidate.setTcNo(createCandidateDto.getTcNo());
		candidate.setBirthYear(createCandidateDto.getBirthYear());
		
		this.candidateDao.save(candidate);
		
		// Send mail verification code
		return new SuccessResult("Candidate added.");
	}

	private Result validate(CreateCandidateDto createCandidateDto) {
		if(createCandidateDto.getFirstName()==null) return new ErrorResult("First name is required");
		if(createCandidateDto.getLastName()==null) return new ErrorResult("Last name is required");
		if(createCandidateDto.getEmail()==null) return new ErrorResult("Email is required");
		if(createCandidateDto.getPassword() == null) new ErrorResult("Passsword is required");
		if(createCandidateDto.getConfirmPassword() == null) new ErrorResult("Confirm password is required");
		if(createCandidateDto.getPassword() != createCandidateDto.getConfirmPassword()) new ErrorResult("Passsword and Confirm password not match");
		if(createCandidateDto.getTcNo() == null) return new ErrorResult("TC no is required");
		if(createCandidateDto.getBirthYear() == 0) return new ErrorResult("Birth Year is required");
		return new SuccessResult();
	}
	
	private Result isExists(CreateCandidateDto createCandidateDto) {
		if(this.candidateDao.findByEmail(createCandidateDto.getEmail()) != null) 
			return new ErrorResult("Candidate is already exists!");
		
		if(this.candidateDao.findByTcNo(createCandidateDto.getTcNo()) != null)
			return new ErrorResult("Candidate is already exists!");	
		
		return new SuccessResult();
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		Candidate candidate = this.candidateDao.getById(candidateId);
		if(candidate == null) {
			return new ErrorDataResult<Candidate>("Candidate not found!");
		}
		return new SuccessDataResult<Candidate>(candidate);
	}

	
}
