package com.cognizant.stockMarketCharting.companyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.companyservice.Repository.CompanyRepository;
import com.cognizant.stockMarketCharting.companyservice.model.Company;
import com.cognizant.stockMarketCharting.companyservice.model.CompanyDTO;

@Service
public class CompanyServiceImpl implements CompanyService {
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository=companyRepository;
	}
	@Autowired
	CompanyRepository companyRepository;
	@Override
	public List<Company> getAllCompanies() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyList(companyRepository.findAll());
		return companyRepository.findAll();
	}

}
