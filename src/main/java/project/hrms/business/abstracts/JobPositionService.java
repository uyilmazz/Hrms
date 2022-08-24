package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concrete.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
}
