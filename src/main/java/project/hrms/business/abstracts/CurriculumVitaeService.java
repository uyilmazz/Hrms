package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concrete.CurriculumVitae;

public interface CurriculumVitaeService {

	Result add(CurriculumVitae curriculumVitae);
	DataResult<List<CurriculumVitae>> getAll();
}
