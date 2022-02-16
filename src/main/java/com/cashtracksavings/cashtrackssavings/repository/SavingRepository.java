package com.cashtracksavings.cashtrackssavings.repository;

import com.cashtracksavings.cashtrackssavings.domain.SaveAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SavingRepository {

    private final EntityManager em;

    // Get Saving Case
    public SaveAccount findByAccNo(int accNo){
        return em.createQuery("select sa from SaveAccount sa where sa.accNo = :accNo", SaveAccount.class)
                .setParameter("accNo", accNo)
                .getSingleResult();
    }

    // Get Savings list
    public List<SaveAccount> findByUserNo(int userNo){
        return em.createQuery("select sa from SaveAccount sa where sa.userNo = :userNo", SaveAccount.class)
                .setParameter("userNo", userNo)
                .getResultList();
    }

    // Saving insert
    public int insertSaving(SaveAccount saveAccount){
        em.persist(saveAccount);
        return saveAccount.getUserNo();
    }

    // Saving delete
    public int deleteSaving(SaveAccount saveAccount){
        int resultInt = saveAccount.getAccNo();
        em.remove(saveAccount);
        return resultInt;
    }
}
