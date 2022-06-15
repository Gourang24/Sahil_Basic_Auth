/*
 * package com.springboot.microservices.user.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.springboot.microservices.user.exception.ResourceNotFoundException;
 * import com.springboot.microservices.user.model.User; import
 * com.springboot.microservices.user.service.UserService;
 * 
 * import java.util.*;
 * 
 * @RestController public class UserController {
 * 
 * @Autowired private UserService userService;
 * 
 * @GetMapping("/users") public ResponseEntity<List<User>> getAllUsers() {
 * List<User> allUsers = this.userService.getAllUsers(); return new
 * ResponseEntity<List<User>>(allUsers, HttpStatus.OK); }
 * 
 * @GetMapping("/user/{userId}") public User findUserById(@PathVariable int
 * userId) { User findUserById =
 * this.userService.findUserById(userId).orElseThrow(()->new
 * ResourceNotFoundException("User","Id",userId)); return findUserById; }
 * 
 * @PostMapping("/user") public ResponseEntity<User> addUserDetail(@RequestBody
 * User user){ User addUserDetail = this.userService.addUserDetail(user); return
 * new ResponseEntity<User>(addUserDetail, HttpStatus.OK); }
 * 
 * @PutMapping("/user/update/{userId}") public User
 * updateUserDetail(@PathVariable int userId, @RequestBody User user) {
 * user.setUserId(userId); return this.userService.updateUserDetail(user,
 * userId); }
 * 
 * @DeleteMapping("/user/delete/{userId}") public void
 * deleteUserById(@PathVariable int userId){
 * this.userService.deleteUserById(userId); }
 * 
 * 
 * }
 */