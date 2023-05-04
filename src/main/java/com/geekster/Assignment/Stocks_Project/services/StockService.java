package com.geekster.Assignment.Stocks_Project.services;

import com.geekster.Assignment.Stocks_Project.models.Stock;
import com.geekster.Assignment.Stocks_Project.repositories.IStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepository stockRepo;
// THis is example of Custom Finder
    public List<Stock> getStockByType(String stockType) {
        return stockRepo.findByStockType(stockType);
    }
 // THis is  a implicit method in CRUD repo
    public String addStocks(List<Stock> stockList) {
        Iterable<Stock>list=stockRepo.saveAll(stockList);
        if(list!=null){
            return "Added List Of Stocks";
        }else {
            return "Unble to Addesd";
        }
    }

    public List<Stock> getStocksAbovePriceAndLowerDate(Double price, String  date) {
        LocalDateTime mydate=LocalDateTime.parse(date);
        return stockRepo.findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockName(price, mydate);
    }

    public List<Stock> getStockAboveMarketCap(Double capPercentage) {
        return stockRepo.getAllStocksAboveMarketCap(capPercentage);
    }

    @Transactional
    public void updateMarketCap(Double marketCap, Integer id) {
        stockRepo.updateMarketByID(marketCap,id);
    }

    @Transactional
    public void deleteStockByCount(Integer userCount) {
        stockRepo.deleteStockBasedOnCount(userCount);
    }
}
