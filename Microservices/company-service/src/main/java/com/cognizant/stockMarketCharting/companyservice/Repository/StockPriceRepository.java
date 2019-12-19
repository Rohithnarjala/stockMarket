package com.cognizant.stockMarketCharting.companyservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.companyservice.model.StockPrice;



@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice,String> {

	@Query(value="select * from stock_price WHERE sp_code=?1 ",nativeQuery = true)
	public List<StockPrice> getAllStockPrice(long companyCode);
	
	@Query(value="select a.* \r\n" + 
			"from stock_price a\r\n" + 
			"	inner join\r\n" + 
			"    (\r\n" + 
			"		select sp_id,sp_stock_exchange, max(sp_date) as max_date, max(sp_time) as max_time\r\n" + 
			"        from stock_price where sp_code =?1 \r\n" + 
			"        group by sp_stock_exchange\r\n" + 
			"    ) b ON a.sp_id = b.sp_id",nativeQuery = true)
	public List<StockPrice> getStockPrice(long companyCode);
	
//	@Query(value="select * from stock_price where sp_code=?1 group by sp_date",nativeQuery = true)
//	public List<StockPrice> getAllStockPrices(long companyCode);
}

