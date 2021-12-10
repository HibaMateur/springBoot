package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository Stockrepo;

	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) this.Stockrepo.findAll();
	}
	
	@Override
	public Stock addStock(Stock c) {
        return this.Stockrepo.save(c);
	}
	@Override
	public void deleteStock(Long id) {
		Stockrepo.deleteById(id);
		
	}

	@Override
	public Stock updateStock(Stock c) {
		Stock Stock = Stockrepo.findById(c.getIdStock()).orElse(null);
		if(Stock != null)
			Stockrepo.save(c);
        return c;
	}

	@Override
	public Stock retrieveStock(Long id) {
		return this.Stockrepo.findById(id).orElse(null);
	}
	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void StockScheduled() {
		List<Stock> stockList;
		stockList = (List<Stock>) Stockrepo.retrieveStock();
		for (Stock stock : stockList) {
			System.out.println(stock.getLibelleStock() + " quantite min "+stock.getQteMin()+" current "+stock.getQte());
		}
	}
	

}
