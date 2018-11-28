package com.triggerme.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triggerme.app.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("tm")
public class EmailController {

	public static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	private EmailService empService;
	
	@RequestMapping(value = "/sendEmailNotification", method = RequestMethod.POST)
	public ResponseEntity<String> getValidEmailStatus(@RequestParam String email, @RequestParam String text, @RequestParam String subject) {
		String isValid =  empService.postEMailNotification(email, text, 1, subject);
			return new ResponseEntity<String>(isValid, HttpStatus.OK);
	}
}
