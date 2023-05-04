package com.geekster.Assignment.Stocks_Project.controllers;

import com.geekster.Assignment.Stocks_Project.models.Stock;
import com.geekster.Assignment.Stocks_Project.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired   //we are Auto Wired StockService
    StockService stockService;

    @GetMapping(value = "/getStock/{stockType}")
    public List<Stock>getStockBasedOnType(@PathVariable String stockType){
   return stockService.getStockByType(stockType);
    }

    @GetMapping(value ="/abovePrice/price/{price}/lowerDate/date/{date}")
    public List<Stock>getStocksAbovePriceAndLowerDate(@PathVariable Double price ,@PathVariable String date){
   return stockService.getStocksAbovePriceAndLowerDate(price,date);
    }
    @GetMapping(value = "/cap/{capPercentage}")
    public List<Stock>getStockAboveMarketCap(@PathVariable Double capPercentage){
        return  stockService.getStockAboveMarketCap(capPercentage);
    }



  //Post
    @PostMapping(value = "/")
    public String inserStocks(@RequestBody List<Stock>stockList){
        return stockService.addStocks(stockList);
    }

    // Update Stocks in list
    @PutMapping (value = "/marketCap/{marketCap}/id/{id}")
    public  void insertStock(@PathVariable  Double marketCap,@PathVariable Integer id){
        stockService.updateMarketCap(marketCap,id);
    }

 //Delete Stocks
    @DeleteMapping(value = "/deleteUserCount/{userCount}")
    public void deleteStock(@PathVariable Integer userCount){
        stockService.deleteStockByCount(userCount);

    }
}
