package project.hrms.business.concrete;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CityService;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.business.abstracts.JobTitleService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.dto.concrete.CreateJobAdvertisementDto;
import project.hrms.dto.concrete.JobAdvertisementDetailDto;
import project.hrms.entities.concrete.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private JobTitleService jobTitleService;
	private EmployerService employerService;
	private CityService cityService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,JobTitleService jobTitleService,EmployerService employerService,CityService cityService) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.jobTitleService = jobTitleService;
		this.employerService = employerService;
		this.cityService = cityService;
	}

	@Override
	public Result add(CreateJobAdvertisementDto createJobAdvertisementDto) {
		
		Result validationResult = validateCreateJobAdvertisementDto(createJobAdvertisementDto);
		if(!validationResult.isSuccess()) return validationResult;
		
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement.setJobTitle(this.jobTitleService.getById(createJobAdvertisementDto.getJobTitleId()).getData());
		jobAdvertisement.setCity(this.cityService.getById(createJobAdvertisementDto.getCityId()).getData());
		jobAdvertisement.setEmployer(this.employerService.getById(createJobAdvertisementDto.getEmployerId()).getData());
		jobAdvertisement.setDeadline(createJobAdvertisementDto.getDeadline());
		jobAdvertisement.setDescription(createJobAdvertisementDto.getDescription());
		jobAdvertisement.setMinSalary(createJobAdvertisementDto.getMinSalary());
		jobAdvertisement.setMaxSalary(createJobAdvertisementDto.getMaxSalary());
		jobAdvertisement.setOpenNumberOfPositions(createJobAdvertisementDto.getOpenNumberOfPositions());
		jobAdvertisement.setCreatedDate(Calendar.getInstance().getTime());
		
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActive() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveSortedByDate() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByCreatedDate());
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_Id(employerId));
	}

	@Override
	public Result doPassiveJobAdvertisement(int jobAdvertisementId, int employerId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
		if(jobAdvertisement == null) {
			return new ErrorResult("Job Advertisement not found!");
		}
		if(jobAdvertisement.getEmployer().getId() != employerId) {
			return new ErrorResult("Only the company that owns the ad can close it.");
		}
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Advertisement updated.");
	}
	
	private Result validateCreateJobAdvertisementDto(CreateJobAdvertisementDto createJobAdvertisementDto) {
		if(createJobAdvertisementDto.getJobTitleId() <= 0) return new ErrorResult("Job title is required.");
		if(createJobAdvertisementDto.getDescription() == null) return new ErrorResult("Description is required.");
		if(createJobAdvertisementDto.getCityId() <= 0) return new ErrorResult("City is required.");
		if(createJobAdvertisementDto.getOpenNumberOfPositions() <= 0) return new ErrorResult("Open number of positions is required");
		return new SuccessResult();
	}

}
