package com.cognizant.stockMarketCharting.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.stockMarketCharting.authenticationservice.model.Role;

public interface RoleRepository  extends  JpaRepository<Role, Integer>  {

}
