package com.cognizant.stockMarketCharting.authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockMarketCharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.security.AppUserDetailsService;



@RestController
@RequestMapping("/stockmarket/users")
@CrossOrigin("*")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@PostMapping
	public boolean signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {

		LOGGER.info("start");
		boolean flag = false;
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		flag = appUserDetailsService.signup(user);
		LOGGER.info("End");
		return flag;
	}
}

