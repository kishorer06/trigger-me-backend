package com.triggerme.app.service;

import java.util.Optional;

import com.triggerme.app.model.User;

public interface UserService {

	User save(User user);

	User update(User user) ;
	
	User find(String userName) ;
	
	Optional<User> findById(String id) ;
}