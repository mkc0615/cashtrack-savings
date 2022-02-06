package com.cashtracksavings.cashtrackssavings.controller;

import com.cashtracksavings.cashtrackssavings.domain.Stock;
import com.cashtracksavings.cashtrackssavings.domain.api.UserStockList;
import com.cashtracksavings.cashtrackssavings.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockApiController {

    @Autowired
    StockService stockService;

    @GetMapping("/list/{userNo}")
    public ResponseEntity<UserStockList> myStocks(@PathVariable("userNo") int userNo){
        List<Stock> resultList = stockService.findStocks(userNo);
        UserStockList response = new UserStockList();
        response.createList(userNo, resultList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Add stock case
    @PostMapping("/add")
    public ResponseEntity<Integer> addStocks(@RequestBody Stock stock){
        int result = stockService.saveStock(stock);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // Update stock case
    @PostMapping("/update")
    public ResponseEntity<Integer> updateStock(@RequestBody Stock stock){
        int result = stockService.updateStock(stock);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
