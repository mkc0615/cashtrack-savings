package com.cashtracksavings.cashtrackssavings.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class SaveAccount extends BaseEntity{

    @Id
    @GeneratedValue
    private int accNo;

    private int userNo;

    private String bankName;
    private int amount;
    private double rate;

    // 내부 생성자 메서드
    public void createSaveAccEntry(
            String bankName, int amount, double rate
    ){
        this.bankName=bankName;
        this.amount=amount;
        this.rate = rate;
    }

    // 은행 수정 메서드
    public void updateBankname(String bankName){
        this.bankName = bankName;
    }

    // 은행 수정 메서드
    public void updateAmount(int amount){
        this.amount = amount;
    }

    // 은행 수정 메서드
    public void updateRate(double rate){
        this.rate = rate;
    }


}
