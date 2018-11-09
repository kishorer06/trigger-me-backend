package com.triggerme.app.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triggerme.app.dao.UserRepository;
import com.triggerme.app.model.User;
import com.triggerme.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.insert(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findByUsername(userName);
	}

	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}
}
