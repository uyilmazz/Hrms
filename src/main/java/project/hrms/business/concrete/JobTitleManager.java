package project.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobTitleDao;
import project.hrms.dto.concrete.CreateJobTitleDto;
import project.hrms.entities.concrete.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public Result add(CreateJobTitleDto createJobTitleDto) {
		Result isExistsResult = this.isExists(createJobTitleDto);
		
		if(!isExistsResult.isSuccess()) return isExistsResult;
		
		JobTitle jobTitle = new JobTitle();
		jobTitle.setTitle(createJobTitleDto.getTitle());
		
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job title added.");
	}
	
	private Result isExists(CreateJobTitleDto createJobTitleDto) {
		if(this.jobTitleDao.findByTitle(createJobTitleDto.getTitle()) != null) return new ErrorResult("Job Title is already exists!");
		return new SuccessResult();
	}

	@Override
	public DataResult<JobTitle> getById(int jobTitleId) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getById(jobTitleId));
	}

}
