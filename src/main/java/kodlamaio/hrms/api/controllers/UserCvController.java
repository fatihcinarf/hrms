package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.UserCvService;
import kodlamaio.hrms.core.utilities.Dtos.UserCvDetailsDto;
import kodlamaio.hrms.core.utilities.Dtos.UserCvDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UserCv;
import kodlamaio.hrms.entities.concretes.UserCvEntity.UserAbilit;

@RestController
@RequestMapping("/api/userCvController")
@CrossOrigin
public class UserCvController {
	@Autowired
	private UserCvService userCvService;

	@GetMapping("/getAllUserCv")
	public DataResult<List<UserCv>> getAllUserCv() {
		return this.userCvService.getAllUserCv();
	}
	
	@GetMapping("/getUserCvDetails")
	public UserCvDetailsDto getByUserCvIdDetails(int userCvId) {
		return this.userCvService.getByUserCvIdDetails(userCvId);
	}

	@GetMapping("/get")
	public UserCv getAllByUser_UserId(int userCvId) {
		return this.userCvService.getAllByUser_UserId(userCvId);
	}

	@PostMapping("/addUserCv")
	public DataResult<UserCv> addUserCv(@RequestBody UserCv userCv) {
		return this.userCvService.addUserCv(userCv);
	}

	@GetMapping("/getByUser_UserIdIn")
	public DataResult<List<UserCv>> getByUser_UserIdIn(@RequestParam List<Integer> users) {
		return this.userCvService.getByUser_UserIdIn(users);
	}

	@GetMapping("/getByUserAbilitId")
	public UserAbilit getByUserAbilitId(@RequestParam int userCvId) {
		return this.userCvService.getByUserAbilitId(userCvId);
	}

	@GetMapping("/getAllUserCvDtosUserCvDto")
	public List<UserCvDto> getAllUserCvDto() {
		return this.userCvService.getAllUserCvDto();
	}

}
