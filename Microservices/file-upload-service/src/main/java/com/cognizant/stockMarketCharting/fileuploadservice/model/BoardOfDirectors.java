package com.cognizant.stockMarketCharting.fileuploadservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "board_members")
public class BoardOfDirectors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bm_id")
	private int id;
	
	@Column(name = "bm_cp_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "bm_cp_id")
	private Company company;

	public BoardOfDirectors() {
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	
}
