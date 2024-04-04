package com.esgreport.service;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class EmailService {


	@Autowired
	 JavaMailSenderImpl getJavaMailSender;

	public void sendEmail(String email,String subject,String message) throws MessagingException {
		MimeMessage msg = getJavaMailSender.createMimeMessage();
		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setText(message,true);
		getJavaMailSender.send(msg);
	}

	public void sendEmailWithAttachment(String email,String subject,String message) throws MessagingException, IOException {
		MimeMessage msg = getJavaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setText("Check attachment for image!");
		helper.setText(message, true);
		File file = new File(this.getClass().getClassLoader().getResource("image.jpg").getFile());
		helper.addAttachment("CoolImage.jpg", file);
		getJavaMailSender.send(msg);
	}
}