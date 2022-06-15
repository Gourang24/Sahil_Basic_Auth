package com.springboot.microservices.user.group.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.microservices.user.dao.UserDao;
import com.springboot.microservices.user.model.User;

import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userdao.findByUserName(username);
        return user.map(GroupUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
    }
}
