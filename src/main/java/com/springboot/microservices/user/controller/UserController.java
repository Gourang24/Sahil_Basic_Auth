package com.springboot.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.user.model.User;
import com.springboot.microservices.user.service.UserService;

import java.util.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/user/{userId}")
	public User findUserById(@PathVariable long userId) {
	return	this.userService.findUserById(userId);
	}
	
	@PostMapping("/user")
	public User addUserDetail(@RequestBody User user){
	return	this.userService.addUserDetail(user);
		
	}
	
	@PutMapping("/user/update/{userId}")
	public User updateUserDetail(@PathVariable long userId, @RequestBody User user) {
	    user.setUserId(userId);
	return this.userService.updateUserDetail(user);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public void deleteUserById(@PathVariable long userId) {
	this.userService.deleteUserById(userId);
	}
}
