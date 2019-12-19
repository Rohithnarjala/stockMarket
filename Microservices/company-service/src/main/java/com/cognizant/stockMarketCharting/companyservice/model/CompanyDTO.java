package com.cognizant.stockMarketCharting.companyservice.model;

import java.util.List;

public class CompanyDTO {
	private List<Company> companyList;

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(List<Company> companyList) {
		super();
		this.companyList = companyList;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	@Override
	public String toString() {
		return "CompanyDTO [companyList=" + companyList + "]";
	}

}