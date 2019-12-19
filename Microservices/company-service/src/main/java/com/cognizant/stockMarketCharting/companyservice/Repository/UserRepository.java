package com.cognizant.stockMarketCharting.companyservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.companyservice.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	
	public Users findByUserName(String username);

}
