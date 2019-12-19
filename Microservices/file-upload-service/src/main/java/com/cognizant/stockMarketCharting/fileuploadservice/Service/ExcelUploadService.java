package com.cognizant.stockMarketCharting.fileuploadservice.Service;

import java.io.FileNotFoundException;

import com.cognizant.stockMarketCharting.fileuploadservice.DTO.ExcelUploadDTO;




public interface ExcelUploadService {
	public void uploadFileService(String filePath) throws FileNotFoundException;
	public ExcelUploadDTO getSummary();
}