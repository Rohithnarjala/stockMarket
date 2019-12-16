package com.cognizant.stockMarketCharting.authenticationservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="User Already Exixts")
public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException() {
		super("User Already Exixts");
	}

}