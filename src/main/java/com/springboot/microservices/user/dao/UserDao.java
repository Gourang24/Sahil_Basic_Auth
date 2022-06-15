package com.springboot.microservices.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservices.user.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, CrudRepository<User, Integer>{

	Optional<User> findByUserName(String username);

}
 