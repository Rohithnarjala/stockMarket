package com.cognizant.stockMarketCharting.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.stockMarketCharting.companyservice.model.Company;
import com.cognizant.stockMarketCharting.companyservice.service.CompanyService;


@RestController
@RequestMapping("/stockmarket")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@GetMapping("/get-company")
	public List<Company> getCompanyList() {
		return companyService.getAllCompanies();
	}
}

