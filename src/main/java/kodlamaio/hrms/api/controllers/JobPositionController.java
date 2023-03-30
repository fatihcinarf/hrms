package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jopPosition.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/joppositioncontroller")
@CrossOrigin
public class JobPositionController {
	private JobPositionService jopPositionService;

	@Autowired
	public JobPositionController(JobPositionService jopPositionService) {
		this.jopPositionService = jopPositionService;
	}
	
	@GetMapping("/getalljopposition")
	public List<JobPosition> getAllJopPosition(){
		return this.jopPositionService.getAllJopPosition();
	}

}
