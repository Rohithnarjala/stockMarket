package com.cognizant.stockMarketCharting.companyservice.service;

import java.util.List;

import com.cognizant.stockMarketCharting.companyservice.model.StockPrice;

public interface StockPriceService {
	public List<StockPrice> getAllStockPrice(long companyCode);

	public List<StockPrice> getLatestStock(long companyCode);

	//public List<StockPrice> getStockForCompany(long companyCode);
}
