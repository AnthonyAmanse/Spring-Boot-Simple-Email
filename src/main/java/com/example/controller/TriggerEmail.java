package com.example.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerEmail {

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(path = "/email", method = RequestMethod.POST)
	private String send() {
		MimeMessage mail = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		try {
			helper.setTo("ghieamanse@gmail.com");
			helper.setFrom("testanthonyamanse@gmail.com");
			helper.setReplyTo("testanthonyamanse@gmail.com");
			helper.setSubject("Notification");
			helper.setText("You got mail.");
			mailSender.send(mail);
			return "{\"message\": \"OK\"}";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"message\": \"Error\"}";
		}
	}

}
