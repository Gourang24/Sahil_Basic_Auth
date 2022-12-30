package com.springboot.microservices.user.service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springboot.microservices.user.group.common.*;
import com.springboot.microservices.user.dao.UserDao;
import com.springboot.microservices.user.exception.ResourceNotFoundException;
import com.springboot.microservices.user.model.User;

@Service
public class UserAuthService {

	@Autowired
	private UserDao userdao;
	
	 @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

// for getting all users
	public List<User> getAllUsers() {
		List<User> findAll = this.userdao.findAll();
		return findAll;
	}

	public Optional<User> findUserById(Long userId) {
		return this.userdao.findById(userId);
		//return user;
		
	}

	public String addUserDetail(User user) {
		if(StringUtils.isEmpty(user.getRoles()))
		 user.setRoles(UserConstant.DEFAULT_ROLE);//USER
	        String encryptedPwd = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encryptedPwd);
	        this.userdao.save(user);
	        return "Hi " + user.getUserName() + " welcome to group !";
	}

	public User updateUserDetail(User user, Long userId) {
		Optional<User> findById = this.userdao.findById(userId);
		if (findById.isPresent()) {
			User save = this.userdao.save(user);
			return save;
	}
	else {
		throw new ResourceNotFoundException("User", "Id", userId);
	}
//		User save = this.userdao.save(user);
//		return save;
	}

	public void deleteUserById(Long userId) {
		//if (userdao.findById(userId).get() != null) {
		 Optional<User> findById = this.userdao.findById(userId);
			if (findById.isPresent()) {
		this.userdao.deleteById(userId);
		}
		else {
			throw new ResourceNotFoundException("User", "Id", userId);
		}
	 }

}
