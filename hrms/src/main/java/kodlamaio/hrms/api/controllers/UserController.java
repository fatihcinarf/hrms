package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jopPosition.CheckJopPositionService;
import kodlamaio.hrms.business.abstracts.jopPosition.JopPositionService;
import kodlamaio.hrms.business.abstracts.user.UserCheckService;
import kodlamaio.hrms.business.abstracts.user.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JopPosition;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/usercontroller")
public class UserController {

	private UserService userService;
	private UserCheckService userCheckService;
	private JopPositionService jopPositionService;
	private CheckJopPositionService checkJopPositionService;
	
	@Autowired
	public UserController(UserService userService, UserCheckService userCheckService,JopPositionService jopPositionService,CheckJopPositionService checkJopPositionService) {
		this.userService = userService;
		this.userCheckService = userCheckService;
		this.jopPositionService = jopPositionService;
		this.checkJopPositionService = checkJopPositionService;
	}
	

	@GetMapping("/getall")
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@GetMapping("/getAllJopPosition")
	public List<JopPosition> getAllJopPosition() {
		return this.jopPositionService.getAllJopPosition();
	}

	@GetMapping("/getByUserEmail")
	public User getByUserEmail(String userEmail) {
		return this.userService.getByUserEmail(userEmail);
	}

	@GetMapping("/getByTcNo")
	public User getByTcNo(String tcNo) {
		return this.userService.getByTcNo(tcNo);
	}

	@GetMapping("/email_and_tcno")
	public List<User> getByTcNoAndUserEmail(@RequestParam String tcNo, @RequestParam String userEmail) {
		return this.userService.getByTcNoAndUserEmail(tcNo, userEmail);
	}

	@GetMapping("/email_or_tcno")
	public List<User> getByTcNoOrUserEmail(@RequestParam String tcNo, @RequestParam String userEmail) {
		return this.userService.getByTcNoOrUserEmail(tcNo, userEmail);
	}

	@PostMapping("/adduser")
	public DataResult<User> addUser(@RequestBody User user) {
		return this.userService.userAdd(user);
	}
	
	@DeleteMapping("/deleteuser")
	public void deleteByUserName(@RequestParam String tcNo) {
		this.userService.deleteByUserName(tcNo);
	}
	
	@PutMapping("/updateuser")
	public DataResult<User> updateUser(@RequestParam String tcNo, @RequestBody User user) {
		return this.userService.updateUser(tcNo, user);
		
	}
	
	// ------------------------- KONTROL ------------------------

	@GetMapping("/isUserAnyEmpty")
	public boolean isUserAnyEmpty(User user) {
		return this.userCheckService.isUserAnyEmpty(user);
	}

	@GetMapping("/existsUserEmail")
	public boolean existsUserEmail(@RequestParam String userEmail) {
		return this.userCheckService.existsUserEmail(userEmail);
	}

	@GetMapping("/existsTcNo")
	public boolean existsTcNo(@RequestParam String tcNo) {
		return this.userCheckService.existsUserEmail(tcNo);
	}

	@GetMapping("/existsJopPosition")
	public boolean existsJopPosition(String jopPositionName) {
		return this.checkJopPositionService.existsJopPosition(jopPositionName);
	}

}
