package com.cognizant.stockMarketCharting.authenticationservice.service;

public interface EmailService {
	void send(String from, String to, String title, String body);
}
