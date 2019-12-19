package com.cognizant.stockMarketCharting.fileuploadservice.Repository;

import java.sql.Time;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.stockMarketCharting.fileuploadservice.model.StockPrice;


@Repository
public interface ExcelUploadRepository extends JpaRepository<StockPrice, Integer> {
	
	@Query(value="select min(sp_date) from stock_price",nativeQuery=true)
	public Date minDate();
	
	@Query(value="select max(sp_date) from stock_price",nativeQuery=true)
	public Date maxDate();
	
	@Query(value="select * from stock_price where sp_date=?1 and sp_time=?2 and sp_company_code=?3 and sp_stock_exchange=?4 LIMIT 1",nativeQuery=true)
	public StockPrice getStock(Date date,Time time,long code,String exchange);
	
}
