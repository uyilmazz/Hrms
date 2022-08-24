package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.dto.concrete.CreateEmployerDto;
import project.hrms.entities.concrete.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(CreateEmployerDto createEmployerDto);
	DataResult<Employer> getById(int employerId);
}
