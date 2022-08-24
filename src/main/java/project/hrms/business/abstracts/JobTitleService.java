package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.dto.concrete.CreateJobTitleDto;
import project.hrms.entities.concrete.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	Result add(CreateJobTitleDto createJobTitleDto);
	DataResult<JobTitle> getById(int jobTitleId);
}
