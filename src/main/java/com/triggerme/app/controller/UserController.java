package com.triggerme.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triggerme.app.errorhandling.CustomErrorType;
import com.triggerme.app.model.User;
import com.triggerme.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("tm")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// request method to create a new account by a guest
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("Email exists: {}", newUser.getUsername());
			return new ResponseEntity(new CustomErrorType("Account already exists!"), HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(@RequestParam String email) {
		return userService.find(email);
	}	
	
}
