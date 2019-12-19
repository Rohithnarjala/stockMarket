package com.cognizant.stockMarketCharting.companyservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_exchange")
public class StockExchange {

	public StockExchange(int id, String name, String brief, String address, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ex_id")
	private int id;
	@Column(name = "ex_stock_exchange")
	private String name;
	@Column(name = "ex_brief")
	private String brief;
	@Column(name = "ex_address")
	private String address;
	@Column(name = "ex_remarks")
	private String remarks;

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


}