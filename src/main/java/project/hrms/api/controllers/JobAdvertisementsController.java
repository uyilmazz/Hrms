package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.dto.concrete.CreateJobAdvertisementDto;
import project.hrms.dto.concrete.JobAdvertisementDetailDto;;

@RestController
@RequestMapping("/api/jobPositions")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisementDetailDto>> getAllActive(){
		return this.jobAdvertisementService.getAllActive();
	}
	
	@GetMapping("/getAllActiveOrderbyDate")
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveOrderByDate(){
		return this.jobAdvertisementService.getAllActiveSortedByDate();
	}
	
	@GetMapping("/getAllActiveAndEmployer")
	public DataResult<List<JobAdvertisementDetailDto>> getAllActiveAndEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.getAllActiveByEmployer(employerId);
	}
	
	@GetMapping("/doPassive")
	public Result doPassiveToJobAdvertisement(@RequestParam int jobAdvertisementId,@RequestParam int employerId) {
		return this.jobAdvertisementService.doPassiveJobAdvertisement(jobAdvertisementId, employerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateJobAdvertisementDto createJobAdvertisementDto) {
		return this.jobAdvertisementService.add(createJobAdvertisementDto);
	}
	
	
	
}
