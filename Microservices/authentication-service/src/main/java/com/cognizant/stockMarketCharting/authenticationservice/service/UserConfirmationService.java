package com.cognizant.stockMarketCharting.authenticationservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.authenticationservice.model.UserConfirmation;
import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.repository.UserConfirmationRepository;
import com.cognizant.stockMarketCharting.authenticationservice.repository.UsersRepository;

@Service
public class UserConfirmationService {

	@Autowired
	UserConfirmationRepository confirmationRepository;
	@Autowired
	UsersRepository userRepository;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Transactional
	public String setTokenForConfirmation(String userId) {
		String token=randomAlphaNumeric();
		UserConfirmation userConfirmation = new UserConfirmation(1, token, userId);
		confirmationRepository.save(userConfirmation);
		return token;
	}
	@Transactional
	public void confirmMailAddress(String token) {
		UserConfirmation userConfirmation=confirmationRepository.findByToken(token);
		if(userConfirmation!=null) {
			confirmationRepository.delete(userConfirmation);
			Users user = userRepository.findByUserName(userConfirmation.getUserId());
			user.setConfirmed(true);
			userRepository.save(user);
		}
	}
	public static String randomAlphaNumeric() {

		int count = 10;
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}

		return builder.toString();

	}
}
