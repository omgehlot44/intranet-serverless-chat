package com.ofaul.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ofaul.business.entity.User;
import com.ofaul.business.repository.UserRepository;

public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	User getByUsernameAndPassword(String username, String password) {
		return this.userRepository.findOneByUsernameAndPassword(username, password);
	}

}
