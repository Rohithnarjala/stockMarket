package com.cognizant.stockMarketCharting.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognizant.stockMarketCharting.authenticationservice.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String us_user_name) throws UsernameNotFoundException;
}
