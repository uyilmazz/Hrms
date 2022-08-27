package project.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import project.hrms.entities.concrete.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVidateDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVidateDao) {
		this.curriculumVidateDao = curriculumVidateDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVidateDao.save(curriculumVitae);
		return new SuccessResult("CurriculumViate added.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
