package com.esgreport;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javassist.Loader;
import org.springframework.stereotype.Service;

@Configuration
public class JavaMailSender  {
	@Bean
	public JavaMailSenderImpl getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    InputStream inputStream = Loader.getSystemResourceAsStream("/application.properties");
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("testveertestveer@gmail.com");
	    mailSender.setPassword("zhnp kade pldc owcm");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText(
	      "This is the test email template for your email:\n%s\n");
	    return message;
	}
}