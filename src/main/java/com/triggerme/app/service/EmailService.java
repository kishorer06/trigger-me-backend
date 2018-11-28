package com.triggerme.app.service;

import javax.mail.SendFailedException;

public interface EmailService {

	/**
	 * 
	 * sends notifications to target email address.
	 * 
	 * @return success or faliure
	 * @throws SendFailedException
	 */
	String postEMailNotification(String email, String text, Integer priority, String subject);

}
