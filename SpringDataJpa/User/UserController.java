package SpringDataJpa.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(value="/users", headers="Accept=application/json")
	public List<User> getAllUser(){
		System.out.println("Retrieve All User"+userService.getUser());
		return userService.getUser();
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		System.out.println("Save the User"+user);
		userService.createUser(user);
		return new ResponseEntity<>("created the user",HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<Object> updateUser(@RequestBody User currentUser) {
		
		User user = userService.findById(currentUser.getUserid());
        if (user==null) {
        	return new ResponseEntity<>("updated the user id is not found",HttpStatus.NOT_FOUND);
        }
        userService.updateUser(currentUser, currentUser.getUserid());
		System.out.println("update the User"+user);
		userService.createUser(user);
		return new ResponseEntity<>("updated the user",HttpStatus.OK);
	}
	
	@PatchMapping("/user")
	public ResponseEntity<Object> updateUserPartially(@RequestBody User currentUser) {
		
		User user = userService.findById(currentUser.getUserid());
        if (user==null) {
        	return new ResponseEntity<>("updated the user id is not found",HttpStatus.NOT_FOUND);
        }
        userService.updateUserPartially(currentUser, currentUser.getUserid());
		return new ResponseEntity<>("updated the user",HttpStatus.OK);
	}
}
