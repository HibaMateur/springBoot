package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockServiceImpl;
@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins="http://localhost:4200")
public class StockRestController {
@Autowired
	
	StockServiceImpl stockService;
	
	
	@GetMapping("/retrieve-all-stocks")

	public List<Stock> getAllStocks() {
		List<Stock> stocks  = stockService.retrieveAllStocks();
		return stocks;
	}
	
	@GetMapping("/retrieve-stock/{stock-id}")
	
		public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	@PostMapping(value="/add-stock")
	
	public Stock addStock(@RequestBody Stock s)
	{
		Stock stock = stockService.addStock(s);
		return stock;
	}

	@PutMapping("/modify-stock/{stock-id}")
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockService.updateStock(stock);
	}

	@DeleteMapping("/remove-stock/{stock-id}")
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}
	

}
