package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManeger implements CityService{
	@Autowired
	CityDao cityDao;
	
	@Override
	public List<City> getAllCities() {
		return this.cityDao.findAll();
	}
}
