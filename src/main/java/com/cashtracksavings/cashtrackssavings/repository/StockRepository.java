package com.cashtracksavings.cashtrackssavings.repository;

import com.cashtracksavings.cashtrackssavings.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager em;

    // Get Stock Case
    public Stock findByStockNo(int stockNo){
        return em.createQuery("select st from Stock st where st.stockNo = :stockNo", Stock.class)
                .setParameter("stockNo", stockNo)
                .getSingleResult();
    }

    // Get Stock list
    public List<Stock> findByUserNo(int userNo){
        return em.createQuery("select sa from Stock sa where sa.userNo = :userNo", Stock.class)
                .setParameter("userNo", userNo)
                .getResultList();
    }

    // Stock insert
    public int insertStock(Stock stock){
        em.persist(stock);
        return stock.getUserNo();
    }

    // Stock delete
    public int deleteStock(Stock stock){
        int resultInt = stock.getStockNo();
        em.remove(stock);
        return resultInt;
    }

}
