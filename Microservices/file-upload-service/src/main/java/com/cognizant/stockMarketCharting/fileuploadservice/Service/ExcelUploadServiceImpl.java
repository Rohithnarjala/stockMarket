package com.cognizant.stockMarketCharting.fileuploadservice.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.fileuploadservice.DTO.ExcelUploadDTO;
import com.cognizant.stockMarketCharting.fileuploadservice.Repository.CompanyRepository;
import com.cognizant.stockMarketCharting.fileuploadservice.Repository.ExcelUploadRepository;
import com.cognizant.stockMarketCharting.fileuploadservice.model.StockPrice;


@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

	 @Autowired
	 ExcelUploadRepository excelUploadRepository;
	 Long companyCodeNew;
	 @Autowired 
	 CompanyRepository companyRepository;
	 ExcelUploadDTO excelUploadDTO =new ExcelUploadDTO();
	@Override
	public void uploadFileService(String filePath) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
			Date minDate=null;
			Date maxDate=null;
		 FileInputStream inputStream = new FileInputStream(filePath);
		 
		
		 int count=0;
		 Workbook workbook;
		try {
			workbook = new XSSFWorkbook(inputStream);
			 Sheet firstSheet = workbook.getSheetAt(0);
	         Iterator<Row> rowIterator = firstSheet.iterator();
	      
            
	            rowIterator.next();
	            
	            while (rowIterator.hasNext() ) {
	                Row nextRow = rowIterator.next();
	               count = count+1;
	                Iterator<Cell> cellIterator = nextRow.cellIterator();
	                StockPrice stockPrice = new StockPrice();
	                while (cellIterator.hasNext()) {
	                    Cell nextCell = cellIterator.next();
	                    int columnIndex = nextCell.getColumnIndex();
	                    switch (columnIndex) {
	                    case 0:
	                        Long companyCode = (long) nextCell.getNumericCellValue();
	                        stockPrice.setCompanyCode(companyCode);
	                        System.out.println("=================>" + stockPrice.getCompanyCode());
	                        companyCodeNew=companyCode;
	                        break;
	                    case 1:
	                        String stockExchange = nextCell.getStringCellValue();
	                        stockPrice.setStockExchange(stockExchange);
	                        System.out.println("=================>" + stockExchange);
	                        break;
	                    case 2:
	                        Long currentPrice = (long) nextCell.getNumericCellValue();
	                        stockPrice.setCurrentPrice(currentPrice);
	                        System.out.println("=================>" + currentPrice);
	                        break;
	                    case 3:
	                    	Date date = nextCell.getDateCellValue();
	                    	if(minDate==null) {
	                    	minDate = date;}
	                    	if(maxDate==null) {
		                    	maxDate = date;}
	                    	if(date.compareTo(minDate)<0) {
	                    		minDate=date;
	                    		
	                    	}
	                    	if(date.compareTo(maxDate)>0) {
	                    		maxDate=date;
	                    		
	                    	}
	                    	stockPrice.setDate(date);
	                    	System.out.println("=================>" + date);
	                    	break;
	                    case 4:
	                    	Date time = nextCell.getDateCellValue();               	
	                    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	                    	stockPrice.setTime(Time.valueOf(sdf.format(time)));
	                    	System.out.println("=================>1212" + Time.valueOf(sdf.format(time)));
	              
	                    	break;
	                    default:
	                   		break;
	                    }
	                }
	                if(stockPrice.getCompanyCode()!=null) {
	                 excelUploadRepository.save(stockPrice);}              
	                }     
	            workbook.close();
	            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count == 0) {
			excelUploadDTO.setNoOfRecords(count);
		}
		else {
			excelUploadDTO.setNoOfRecords(count-1);
		}
		excelUploadDTO.setCompanyName(companyRepository.findByCompanyCode(companyCodeNew).getName());
		excelUploadDTO.setMaxDate(maxDate);
		excelUploadDTO.setMinDate(minDate);
		
		System.out.println(excelUploadDTO);
		
	}
	

	@Override
	public ExcelUploadDTO getSummary() {
		// TODO Auto-generated method stub
		return excelUploadDTO;
	}

}

