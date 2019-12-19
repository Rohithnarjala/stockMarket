package com.cognizant.stockMarketCharting.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockMarketCharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.security.AppUserDetailsService;
import com.cognizant.stockMarketCharting.authenticationservice.service.EmailServiceImpl;
import com.cognizant.stockMarketCharting.authenticationservice.service.UserConfirmationService;
import com.cognizant.stockMarketCharting.authenticationservice.service.UserService;



@RestController
@RequestMapping("/stockmarket/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserConfirmationService userConfirmationService;
	
	@Autowired
	EmailServiceImpl emailServiceImpl;
	
	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {
		LOGGER.info("start");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		appUserDetailsService.signup(user);
		String token = userConfirmationService.setTokenForConfirmation(user.getUserName());
		emailServiceImpl.send("ctstestmail10@gmail.com", user.getEmail(), "confirm yyour email", "http://localhost:8082/authentication-service/stockmarket/users/confirm/"+token);
		LOGGER.info("End");
	}
	@GetMapping("/{user}")
	public Users getUser(@PathVariable String user) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return userService.getUser(user);
		
	}
	@GetMapping("/confirm/{token}")
	public void confirmMail(@PathVariable String token) {
		userConfirmationService.confirmMailAddress(token);
	}
	@PutMapping
	public void editUserDetails(@RequestBody Users user ) {
		LOGGER.info("Start");
		userService.editUserDetails(user);
		LOGGER.info("End");
	}
}

