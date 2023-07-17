package com.aditya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.model.Mail;
import com.aditya.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/about")
	public String about() {
		return "This is a external project to handle email sending.";
	}

	@PostMapping("/sendPlainTextEmail")
	public ResponseEntity<String> sendPlainTextEmail(@RequestBody Mail mail) {
		emailService.sendPlainTextEmail(mail);
		return new ResponseEntity<>("Mail Sent to " + mail.getTo(), HttpStatus.OK);
	}

	@PostMapping("/sendHTMLEmailWithInlineImage")
	public ResponseEntity<String> sendHTMLEmailWithInlineImage(@RequestBody Mail mail) throws MessagingException {
		emailService.sendHTMLEmailWithInlineImage(mail);
		return new ResponseEntity<>("Mail Sent to " + mail.getTo(), HttpStatus.OK);
	}

	@PostMapping("/sendHTMLEmail")
	public ResponseEntity<String> sendHTMLEmail(@RequestBody Mail mail) throws MessagingException {
		emailService.sendHTMLEmail(mail);
		return new ResponseEntity<>("Mail Sent to " + mail.getTo(), HttpStatus.OK);
	}

	@PostMapping("/sendHTMLEmailWithAttachment")
	public ResponseEntity<String> sendHTMLEmailWithAttachment(@RequestBody Mail mail) throws MessagingException {
		emailService.sendHTMLEmailWithAttachment(mail);
		return new ResponseEntity<>("Mail Sent to " + mail.getTo(), HttpStatus.OK);
	}

}
