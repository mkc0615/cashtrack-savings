package com.cashtracksavings.cashtrackssavings.domain.api;

import com.cashtracksavings.cashtrackssavings.domain.SaveAccount;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserSavingList {

    private int userNo;

    List<SaveAccount> savingsList = new ArrayList<>();

    public void createList(int userNo, List<SaveAccount> savingsList){
        this.userNo = userNo;
        this.savingsList = savingsList;
    }
}
