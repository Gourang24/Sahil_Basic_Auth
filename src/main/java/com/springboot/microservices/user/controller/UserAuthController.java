package com.springboot.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.user.exception.ResourceNotFoundException;
import com.springboot.microservices.user.model.User;
import com.springboot.microservices.user.service.UserAuthService;

import java.util.*;

@RestController
public class UserAuthController {

	@Autowired
	private UserAuthService userService;
	
	@GetMapping("/users")
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUsers() {
	 List<User> allUsers = this.userService.getAllUsers();
	 return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public User findUserById(@PathVariable int userId) {
		User findUserById = this.userService.findUserById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
				return findUserById;
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> addUserDetail(@RequestBody User user){
		  this.userService.addUserDetail(user);
		return new ResponseEntity<>("user has been saved" , HttpStatus.OK);
	}
	
	@PutMapping("/user/update/{userId}")
	public User updateUserDetail(@PathVariable int userId, @RequestBody User user) {
	    user.setUserId(userId);
	return this.userService.updateUserDetail(user, userId);
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/user/delete/{userId}")
	public void deleteUserById(@PathVariable int userId){
			this.userService.deleteUserById(userId);
		}
	
	
}
