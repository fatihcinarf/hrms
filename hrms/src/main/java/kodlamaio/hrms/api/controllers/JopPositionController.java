package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jopPosition.JopPositionService;
import kodlamaio.hrms.entities.concretes.JopPosition;

@RestController
@RequestMapping("/api/jopcontroller")
public class JopPositionController {
	private JopPositionService jopPositionService;

	@Autowired
	public JopPositionController(JopPositionService jopPositionService) {
		this.jopPositionService = jopPositionService;
	}


}
