package com.cognizant.stockMarketCharting.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.authenticationservice.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String userName) throws UsernameNotFoundException;
	
}
