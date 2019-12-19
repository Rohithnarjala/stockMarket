package com.cognizant.stockMarketCharting.companyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.companyservice.Repository.StockPriceRepository;
import com.cognizant.stockMarketCharting.companyservice.model.StockPrice;
@Service
public class StockPriceServiceImpl implements StockPriceService{

	public StockPriceServiceImpl(StockPriceRepository stockPriceRepository) {
		super();
		this.stockPriceRepository=stockPriceRepository;
	}
	@Autowired
	StockPriceRepository stockPriceRepository;
	@Override
	public List<StockPrice> getAllStockPrice(long companyCode) {
		// TODO Auto-generated method stub
		return stockPriceRepository.getAllStockPrice(companyCode);
	}
	@Override
	public List<StockPrice> getLatestStock(long companyCode) {
		// TODO Auto-generated method stub
		return stockPriceRepository.getStockPrice(companyCode);
	}
//	@Override
//	public List<StockPrice> getStockForCompany(long companyCode) {
//		// TODO Auto-generated method stub
//		return stockPriceRepository.getAllStockPrices(companyCode);
//	}

}
