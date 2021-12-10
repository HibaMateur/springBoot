package tn.esprit.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.ExcelFileService;

@RestController
public class ExportExcelController {
	@Autowired
	private StockRepository stockRepository; 
	
	@Autowired
	private ExcelFileService excelFileService;
	
	@GetMapping("/export-excel")
    public String index() {
        return "index";
    }
	
	@GetMapping("/downloadExcelFile")
	public void downloadExcelFile(HttpServletResponse response) throws IOException {
		List<Stock> stocks = (List<Stock>)stockRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = excelFileService.export(stocks);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=stocks.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
	}
}
