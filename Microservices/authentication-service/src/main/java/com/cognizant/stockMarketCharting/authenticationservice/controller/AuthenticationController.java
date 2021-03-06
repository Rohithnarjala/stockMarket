package com.cognizant.stockMarketCharting.authenticationservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.service.UserService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/stockmarket")
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/authentication")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start");
		Map<String, String> data = new HashMap<>();
		String role = SecurityContextHolder.getContext()
					.getAuthentication().getAuthorities()
					.toArray()[0].toString();
		Authentication authentication = SecurityContextHolder.getContext()
										.getAuthentication();
		String user = authentication.getName();
		Users users=userService.getByUserName(user);
		data.put("token", generateJwt(getUser(authHeader)));
		data.put("role", role);
		data.put("user", user);
		data.put("confirmed", users.isConfirmed()+"");
		LOGGER.info("End");
		return data;

	}

	private String getUser(String authHeader) {
		LOGGER.info("Start");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("End");
		return decodedCredentials.split(":")[0];
		
	}

	private String generateJwt(String user) {
		LOGGER.info("Start");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		LOGGER.info("End");
		return token;
	}
}


