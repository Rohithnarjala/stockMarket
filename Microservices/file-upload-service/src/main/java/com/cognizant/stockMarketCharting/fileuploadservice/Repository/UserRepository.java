package com.cognizant.stockMarketCharting.fileuploadservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.fileuploadservice.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByUserName(String username);
}