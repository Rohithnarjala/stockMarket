package com.cognizant.stockMarketCharting.companyservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.companyservice.model.Company;



@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

}
