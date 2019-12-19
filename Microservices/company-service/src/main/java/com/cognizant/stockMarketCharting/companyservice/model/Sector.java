package com.cognizant.stockMarketCharting.companyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="sector")
public class Sector {


	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="se_id")
	private int id;
	
	@NotNull
	@Column(name="se_sector_name")
	private String sectorName;
	
	@NotNull
	@Column(name="se_brief")
	private String aboutSector;
	
	public Sector() {}

	public Sector(@NotNull int id, @NotNull String sectorName, @NotNull String aboutSector) {
		super();
		this.id = id;
		this.sectorName = sectorName;
		this.aboutSector = aboutSector;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getAboutSector() {
		return aboutSector;
	}

	public void setAboutSector(String aboutSector) {
		this.aboutSector = aboutSector;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sectorName=" + sectorName + ", aboutSector=" + aboutSector + "]";
	}
	
	
}
