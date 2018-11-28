package com.triggerme.app.serviceimpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.triggerme.app.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	private static final String ERROR_WHILE_SENDING_MAIL = "Error while sending mail ...";

	public static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender sender;

	@Override
	public String postEMailNotification(String email, String text, Integer priority, String subject) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {
			helper.setTo(email);
			helper.setText(text);
			helper.setSubject(subject);
			helper.setPriority(priority);
			sender.send(message);
		} catch (MessagingException me) {
			logger.error("postEMailNotification:  failed!", me);
			return ERROR_WHILE_SENDING_MAIL;
		} catch (MailSendException mse) {
			logger.error("postEMailNotification: failed!", mse);
			if (mse.getMessage().contains("Invalid Addresses"))
				return "Error: Invalid Email Address!";
			else
				return ERROR_WHILE_SENDING_MAIL;
		}
		return "Success: Mail sent! please check your inbox. If not found, please enter valid email.";
	}
}
