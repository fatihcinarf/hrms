package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jopPosition.JobPositionService;
import kodlamaio.hrms.business.abstracts.user.UserService;
import kodlamaio.hrms.core.utilities.Dtos.UserSaveDto;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/usercontroller")
@CrossOrigin
public class UserController {

	private UserService userService;
	private JobPositionService jopPositionService;

	@Autowired
	public UserController(UserService userService, 
			JobPositionService jopPositionService ) {
		this.userService = userService;
		this.jopPositionService = jopPositionService;
	}

	@GetMapping("/getByUserId")
	public User getByUserId(int userId) {
		return this.userService.getByUserId(userId);
	}
	
	@GetMapping("/getall")
	public List<User> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/getAllJopPosition")
	public List<JobPosition> getAllJopPosition() {
		return this.jopPositionService.getAllJopPosition();
	}

	@PostMapping("/adduser")
	public DataResult<User> addUser(@RequestBody User user){
		return this.userService.userAdd(user);
	}
	
	@PostMapping("/saveUserDto")
	public ResponseEntity<?> saveUserDto(@RequestBody UserSaveDto userSaveDto){
		return this.userService.userSaveDto(userSaveDto);
	}

	@DeleteMapping("/deleteuser")
	public void deleteByUserName(@RequestParam String tcNo){
		this.userService.deleteByUserName(tcNo);
	}

	@PutMapping("/updateuser")
	public DataResult<User> updateUser(@RequestParam String tcNo, @RequestBody User user) {
		return this.userService.updateUser(tcNo, user);

	}
	
	
	/*
	 * @GetMapping("/getByUserEmail") public User getByUserEmail(String userEmail) {
	 * return this.userService.getByUserEmail(userEmail); }
	 * 
	 * @GetMapping("/getByTcNo") public User getByTcNo(String tcNo) { return
	 * this.userService.getByTcNo(tcNo); }
	 */
	
	
	// ------------------------- KONTROL ------------------------

	/*
	 * @GetMapping("/email_and_tcno") public List<User>
	 * getByTcNoAndUserEmail(@RequestParam String tcNo, @RequestParam String
	 * userEmail) { return this.userService.getByTcNoAndUserEmail(tcNo, userEmail);
	 * }
	 * 
	 * @GetMapping("/email_or_tcno") public List<User>
	 * getByTcNoOrUserEmail(@RequestParam String tcNo, @RequestParam String
	 * userEmail) { return this.userService.getByTcNoOrUserEmail(tcNo, userEmail); }
	 * 
	 * @GetMapping("/isUserAnyEmpty") public boolean isUserAnyEmpty(User user) {
	 * return this.userCheckService.isUserAnyEmpty(user); }
	 * 
	 * @GetMapping("/existsUserEmail") public boolean existsUserEmail(@RequestParam
	 * String userEmail) { return this.userCheckService.existsUserEmail(userEmail);
	 * }
	 * 
	 * @GetMapping("/existsTcNo") public boolean existsTcNo(@RequestParam String
	 * tcNo) { return this.userCheckService.existsUserEmail(tcNo); }
	 * 
	 * @GetMapping("/existsJopPosition") public boolean existsJopPosition(String
	 * jopPositionName) { return
	 * this.checkJopPositionService.existsJopPosition(jopPositionName); }
	 */
}
