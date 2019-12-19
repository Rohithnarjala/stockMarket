package com.cognizant.stockMarketCharting.fileuploadservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock_exchange")
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ex_id")
	private int id;
	@Column(name = "ex_stock_exchange")
	private String name;
	@Column(name = "ex_brief")
	private String brief;
	@Column(name = "ex_address")
	private String address;
	@Column(name = "ex_remarks")
	private String remarks;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "company_stock",
			joinColumns = @JoinColumn(name = "cs_ex_id"),
			inverseJoinColumns = @JoinColumn(name="cs_cp_id"))
	private Set<Company> companyList;

	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(Set<Company> companyList) {
		this.companyList = companyList;
	}
	
	
}

