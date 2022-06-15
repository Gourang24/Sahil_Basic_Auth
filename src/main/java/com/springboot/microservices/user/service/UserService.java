/*
 * package com.springboot.microservices.user.service;
 * 
 * import java.lang.module.ResolutionException; import java.util.List; import
 * java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.springboot.microservices.user.dao.UserDao; import
 * com.springboot.microservices.user.exception.ResourceNotFoundException; import
 * com.springboot.microservices.user.model.User;
 * 
 * @Service public class UserService {
 * 
 * @Autowired private UserDao userdao;
 * 
 * // for getting all users public List<User> getAllUsers() { List<User> findAll
 * = this.userdao.findAll(); return findAll; }
 * 
 * public Optional<User> findUserById(int userId) { return
 * this.userdao.findById(userId); //return user;
 * 
 * }
 * 
 * public User addUserDetail(User user) { User save = this.userdao.save(user);
 * return save; }
 * 
 * public User updateUserDetail(User user, int userId) { Optional<User> findById
 * = this.userdao.findById(userId); if (findById.isPresent()) { User save =
 * this.userdao.save(user); return save; } else { throw new
 * ResourceNotFoundException("User", "Id", userId); } // User save =
 * this.userdao.save(user); // return save; }
 * 
 * public void deleteUserById(int userId) { //if (userdao.findById(userId).get()
 * != null) { Optional<User> findById = this.userdao.findById(userId); if
 * (findById.isPresent()) { this.userdao.deleteById(userId); } else { throw new
 * ResourceNotFoundException("User", "Id", userId); } }
 * 
 * }
 */