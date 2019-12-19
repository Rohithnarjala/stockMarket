package com.cognizant.stockMarketCharting.companyservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.companyservice.Repository.UserRepository;
import com.cognizant.stockMarketCharting.companyservice.model.Users;



@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser;
		Users user = userRepository.findByUserName(username);
		if(user.getUserName() == null) {
			throw new UsernameNotFoundException("User not found"); 
		}else {
			appUser = new AppUser(user);  
		}
		return appUser; 
	}
	
	
	

}
