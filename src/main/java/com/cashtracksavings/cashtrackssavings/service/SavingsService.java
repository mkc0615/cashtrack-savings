package com.cashtracksavings.cashtrackssavings.service;

import com.cashtracksavings.cashtrackssavings.domain.SaveAccount;
import com.cashtracksavings.cashtrackssavings.repository.SavingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SavingsService {

    private final SavingRepository saveRepository;

    // Get Saving Case
    public SaveAccount findSavingCase(int accNo){
        return saveRepository.findByAccNo(accNo);
    }

    // Get Saving list
    public List<SaveAccount> findSavings(int userNo) {
        return saveRepository.findByUserNo(userNo);
    }

    // Saving insert
    public int saveSaving(SaveAccount saveAccount){
        return saveRepository.insertSaving(saveAccount);
    }

    // Saving update
    public int updateSaving(SaveAccount saveAccount){
        int thisAccNo = saveAccount.getAccNo();
        SaveAccount modifyCase = findSavingCase(thisAccNo);

        modifyCase.updateBankname(saveAccount.getBankName());
        modifyCase.updateAmount(saveAccount.getAmount());
        modifyCase.updateRate(saveAccount.getRate());

        return saveRepository.insertSaving(modifyCase);
    }
}
