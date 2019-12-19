package com.cognizant.stockMarketCharting.fileuploadservice.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_price")
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sp_id")
	private int id;
	
	@Column(name="sp_code")
	private Long companyCode;
	
	@Column(name="sp_stock_exchange")
	private String stockExchange;
	
	@Column(name="sp_current_price")
	private Long currentPrice;
	
	@Column(name="sp_date")
	private Date date;
	
	@Column(name="sp_time")
	private Time time;
	
	public StockPrice() {
		super();
	
	}

	public StockPrice(int id, Long companyCode, String stockExchange, Long currentPrice, Date date, Time time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", companyCode=" + companyCode + ", stockExchange=" + stockExchange
				+ ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}
	
	
	
	
}

