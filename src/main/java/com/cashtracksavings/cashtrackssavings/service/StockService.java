package com.cashtracksavings.cashtrackssavings.service;

import com.cashtracksavings.cashtrackssavings.domain.Stock;
import com.cashtracksavings.cashtrackssavings.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    // Get Stock Case
    public Stock findStockCase(int stockNo){
        return stockRepository.findByStockNo(stockNo);
    }

    // Get Stock list
    public List<Stock> findStocks(int userNo){
        return stockRepository.findByUserNo(userNo);
    }

    // Stock insert
    public int saveStock(Stock stock){
        return stockRepository.insertStock(stock);
    }

    // Stock update
    public int updateStock(Stock stock){
        int thisStockNo = stock.getStockNo();
        Stock modifyCase = findStockCase(thisStockNo);
        String sellDate = "2022-01-30";
        modifyCase.updateSellDate(sellDate);
        return stockRepository.insertStock(modifyCase);
    }

    public List<Integer> findStockRate(List<Stock> stockList){

        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        while(i < stockList.size()){
            if(i > 0) {
                int thisDiff = stockList.get(i).getPrice() - stockList.get(i-1).getPrice();
                resultList.add(thisDiff);
            }
            i++;
        }

        return resultList;
    }
}
