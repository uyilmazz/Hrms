package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.concrete.JobPositionManager;
import project.hrms.entities.concrete.JobPosition;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

	private JobPositionManager jobPositoinManager;

	@Autowired
	public JobPositionsController(JobPositionManager jobPositoinManager) {
		this.jobPositoinManager = jobPositoinManager;
	}	
	
	@GetMapping("/getAll")
	public List<JobPosition> getAll(){
		return this.jobPositoinManager.getAll();
	}
	

}
