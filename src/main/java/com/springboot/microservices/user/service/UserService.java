package com.springboot.microservices.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservices.user.dao.UserDao;
import com.springboot.microservices.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

// for getting all users
	public List<User> getAllUsers() {
		List<User> findAll = this.userdao.findAll();
		return findAll;
	}

	public User findUserById(long userId) {
		User user = this.userdao.findById(userId).get();
		return user;
		
	}

	public User addUserDetail(User user) {
		User save = this.userdao.save(user);
		return save;
	}

	public User updateUserDetail(User user) {
		User save = this.userdao.save(user);
		return save;
	}

	public void deleteUserById(long userId) {
		this.userdao.deleteById(userId);
		
	}

}
