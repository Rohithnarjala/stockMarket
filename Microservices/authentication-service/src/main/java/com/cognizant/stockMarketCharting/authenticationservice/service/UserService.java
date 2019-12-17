package com.cognizant.stockMarketCharting.authenticationservice.service;

import com.cognizant.stockMarketCharting.authenticationservice.model.Users;

public interface UserService {

	public Users getUser(String user);
	public Users getByUserName(String userName) ;
	public void editUserDetails(Users user);

}
