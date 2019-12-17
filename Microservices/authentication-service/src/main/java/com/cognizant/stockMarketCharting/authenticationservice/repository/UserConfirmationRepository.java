package com.cognizant.stockMarketCharting.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.authenticationservice.model.UserConfirmation;


@Repository
public interface UserConfirmationRepository extends JpaRepository<UserConfirmation, String> {

	public UserConfirmation findByToken(String token);
	
	@Query(value="insert into confirmation_table values(default,:token,:userId);",nativeQuery = true)
	public void saveDetails(@Param("token") String token, @Param("userId") String userId);
}