package com.admin.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.admin.datamodel.User;
import com.admin.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	// -------------------Retrieve All
	// Users---------------------------------------------
	@RequestMapping(value = "/userall/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		return response();
	}

	private ResponseEntity<List<User>> response() {
		List<User> users = userService.getAllUser();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// ------------------Save User Details

	@RequestMapping(value = "/save-user/", method = RequestMethod.POST)
	public ResponseEntity<User> SaveUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) {
		User usersave = userService.SaveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<User>(headers, HttpStatus.CREATED);// usersave.getId();

	}

	// ---------------Get user by
	// Id----------------------------------------------
	@GetMapping("/getUser/{id}")
	public User getUserByid(@PathVariable(value = "id") Long id) {
		User user = getUser(id);

		return user; // userService.getUserByid(id);
	}

	private User getUser(Long id) {
		User user = userService.getUserByid(id);
		return user;
	}

	private String getPincode(Long id, User user) {
		return userService.getPincode(id);
	}

	// ---------------------update user by id

	/*
	 * @PutMapping("/updateUserById/{id}") public User
	 * updateUserByid(@PathVariable(value = "id") Long id, @Valid @RequestBody
	 * User user) {
	 * 
	 * return userService.updateUserById(id, user); }
	 * 
	 * // ------------delete user by id------------------------------
	 * 
	 * @DeleteMapping("/deleteUser/{id}") public ResponseEntity<User>
	 * deleteUserById(@PathVariable(value = "id") Long id) { Optional<User>
	 * userfind = userService.getUserByid(id); if (!userfind.isPresent()) {
	 * return new ResponseEntity<User>(HttpStatus.NOT_FOUND); } User userdelete
	 * = userService.deleteUserByid(id); return new
	 * ResponseEntity<User>(HttpStatus.NO_CONTENT); //
	 * userService.deleteUserByid(id); }
	 */

}
