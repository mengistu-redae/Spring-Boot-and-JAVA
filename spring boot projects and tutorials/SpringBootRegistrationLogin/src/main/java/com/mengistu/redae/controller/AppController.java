package com.mengistu.redae.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengistu.redae.model.User;
import com.mengistu.redae.repositoryDAO.UserRepositoryDAO;
import com.mengistu.redae.service.UserRegisterServices;

@Controller
public class AppController {

	@Autowired
	private UserRepositoryDAO userRepo;

	@Autowired
	private UserRegisterServices userSrvice; // for registering a user and sending verification mail

	@GetMapping({"/", "/index" })
	public String viewHomePage() {

		// System.out.println("Hi from AppController - viewHomePage ");
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {

		// System.out.println("Hi from AppController - showRegistrationForm ");
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user, HttpServletRequest request)
			throws UnsupportedEncodingException, MessagingException {
		
		/*
		 * we use BCryptPasswordEncoder to encode the user’s password so the password
		 * itself is not stored in database (for better security) – only the hash value
		 * of the password is stored.
		 * 
		 * 
		 * BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); String
		 * encodedPassword = passwordEncoder.encode(user.getPassword());
		 * user.setPassword(encodedPassword);
		 * 
		 * userRepo.save(user);
		 */
		
		//"getSiteURL()" method is below
		userSrvice.register(user, getSiteURL(request));
		
		return "register_success";
	}
	
	//used in the "processRegister()" method
	//returns the real context path of the web application, so the 
	//verification link will work when the user opens the email.
	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "users";
	}
	
	@GetMapping("/verify")
	public String verifyUser(@RequestParam("code") String code) {
	    if (userSrvice.verify(code)) {
	        return "verify_success";
	    } else {
	        return "verify_fail";
	    }
	}
}


