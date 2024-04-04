package com.esgreport.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.service.EmailService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/email")
public class SendEmailController {
	
	@Autowired
	EmailService emailService;

	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
		//emailService.sendEmail("testveertestveer@gmail.com", "Testing from Spring Boot", "Hello World \n Spring Boot Email");
		emailService.sendEmailWithAttachment("testveertestveer@gmail.com", "Testing from Spring Boot", "Hello World \n Spring Boot Email");
	   return "Email sent successfully";   
	}
}