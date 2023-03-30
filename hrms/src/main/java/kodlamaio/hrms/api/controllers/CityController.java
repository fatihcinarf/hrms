package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {
	@Autowired
	CityService cityService;
	
	@GetMapping("/getAllCity")
	public List<City> getAllCity() {
		return this.cityService.getAllCities();
	}
	
}
