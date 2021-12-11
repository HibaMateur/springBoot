package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
import tp.esprit.spring.excel.helper.ExcelHelper;

@Service
public class ImportExcelService {
	@Autowired
	  StockRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<Stock> stocks = ExcelHelper.excelToStocks(file.getInputStream());
	      repository.saveAll(stocks);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<Stock> getAllStocks() {
	    return repository.findAll();
	  }
}
