package project.hrms.business.abstracts;


import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.dto.concrete.CreateCandidateDto;
import project.hrms.entities.concrete.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(CreateCandidateDto createCandidateDto);
	DataResult<Candidate> getById(int candidateId);
}
