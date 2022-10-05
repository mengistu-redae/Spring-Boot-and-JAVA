package com.mengistu.redae.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mengistu.redae.model.User;
import com.mengistu.redae.repositoryDAO.UserRepositoryDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServices {

	@Autowired
	private UserRepositoryDAO userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	public void register(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		//System.out.println("this is the encoded password: " + encodedPassword);

		String randomCode = RandomString.make(64);
		user.setVerificationCode(randomCode);
		user.setEnabled(false);

		userRepo.save(user);
		
		
		/*
		 * To work with sending verification mail functionality, it requires the following:
		 * 	~ JavaMail maven dependency
		 * 	~ Configure some properties for SMTP server in the Spring Boot application.properties file
		 * 	~ Turn on SMTP in your Google Account settings. And to set this, you need to have 
		 * 	  a google workspace account at https://workspace.google.com
		 * 
		 * Therefore, since google workspace is not free and I have not an account, 
		 * the below "sendVerificationEmail" method generates server side exception. 
		 * Thus, I have disabled it from being called.
		 */
		//sendVerificationEmail(user, siteURL);
	}

	/*
	 * send an email to the user’s email (captured from the signup form), with the
	 * verification hyperlink w/c includes the verification code. The value of
	 * siteURL is sent from the controller.
	 * 
	 * To enable sending verification mail feature, uncomment the line calling the
	 * "sendVerificationEmail()" method in the body of the above user 
	 * registering method - register()
	 */
	private void sendVerificationEmail(User user, String siteURL)
			throws UnsupportedEncodingException, MessagingException {

		String toAddress = user.getEmail();
		String fromAddress = "Your email address";
		String senderName = "Your company name";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "Your company name.";

		/*
		 * This class represents a MIME style email message. It implements the Message
		 * abstract class and the MimePart interface.
		 * 
		 * Clients wanting to create new MIME style messages will instantiate an empty
		 * MimeMessage object and then fill it with appropriate attributes and content.
		 */
		MimeMessage message = mailSender.createMimeMessage();

		// "MimeMessageHelper" is a helper class for populating a
		// "javax.mail.internet.MimeMessage"
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", user.getFullName());
		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);

		mailSender.send(message);
	}

	public boolean verify(String verificationCode) {
		User user = userRepo.findByVerificationCode(verificationCode);

		if (user == null || user.isEnabled()) {
			return false;
		} else {
			user.setVerificationCode(null);
			user.setEnabled(true);
			userRepo.save(user);

			return true;
		}
	}
}
