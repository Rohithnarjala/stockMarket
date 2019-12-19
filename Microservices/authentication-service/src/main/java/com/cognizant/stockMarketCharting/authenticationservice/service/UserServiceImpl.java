package com.cognizant.stockMarketCharting.authenticationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired 
	UsersRepository userRepository;
	
	@Autowired 
	PasswordEncoder encoder;
	@Override
	public Users getUser(String user) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return userRepository.findByUserName(user);
	}
	@Override
	public void editUserDetails(Users user) {
		LOGGER.info("Start");
		LOGGER.info("End");
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		
	}
	@Override
	public Users getByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}
