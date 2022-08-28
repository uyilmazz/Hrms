package project.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.abstracts.CurriculumVitaeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import project.hrms.dto.concrete.CreateCurriculumVitaeDto;
import project.hrms.entities.concrete.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVidateDao;
	private CandidateService candidateService;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVidateDao,CandidateService candidateService) {
		this.curriculumVidateDao = curriculumVidateDao;
		this.candidateService = candidateService;
	}

	
//	@Override
//	public Result addDto(CreateCurriculumVitaeDto createCurriculumVitaeDto) {
//		
//		CurriculumVitae curriculumVitae = new CurriculumVitae();
//		curriculumVitae.setCandidate(this.candidateService.getById(createCurriculumVitaeDto.getCandidateId()).getData());
//		curriculumVitae.setDriverLicense(createCurriculumVitaeDto.getDriverLicense());
//		curriculumVitae.setGender(createCurriculumVitaeDto.getGender());
//		curriculumVitae.setGithubAddress(createCurriculumVitaeDto.getGithubAddress());
////		curriculumVitae.setJobExperiences(createCurriculumVitaeDto.getCreateJobExperience());
//		this.curriculumVidateDao.save(curriculumVitae);
//		return new SuccessResult("CurriculumViateDto added.");
//	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		CurriculumVitae created = this.curriculumVidateDao.save(curriculumVitae);
		return new SuccessResult(created.toString());
	}


	@Override
	public DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVidateDao.getByCandidateId(candidateId));
	}
}
