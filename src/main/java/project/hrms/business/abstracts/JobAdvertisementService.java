package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.dto.concrete.CreateJobAdvertisementDto;
import project.hrms.dto.concrete.JobAdvertisementDetailDto;

public interface JobAdvertisementService {
	
	Result add(CreateJobAdvertisementDto createJobAdvertisementDto);
	DataResult<List<JobAdvertisementDetailDto>> getAllActive();
	DataResult<List<JobAdvertisementDetailDto>> getAllActiveSortedByDate();
	DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployer(int employerId);
	Result doPassiveJobAdvertisement(int jobAdvertisementId,int employerId);
}
