package com.cashtracksavings.cashtrackssavings.controller;

import com.cashtracksavings.cashtrackssavings.domain.SaveAccount;
import com.cashtracksavings.cashtrackssavings.domain.api.UserSavingList;
import com.cashtracksavings.cashtrackssavings.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saving")
public class SavingsApiController {

    @Autowired
    SavingsService saveService;

    // Get my saving case
    @GetMapping("/case/{accNo}")
    public ResponseEntity<SaveAccount> mySaving(@PathVariable("accNo") int accNo){
        SaveAccount resultCase = saveService.findSavingCase(accNo);
        return ResponseEntity.status(HttpStatus.OK).body(resultCase);
    }

    // Get my savings list
    @GetMapping("/list/{userNo}")
    public ResponseEntity<UserSavingList> mySavingList(@PathVariable("userNo") int userNo){
        List<SaveAccount> resultList = saveService.findSavings(userNo);
        UserSavingList response = new UserSavingList();
        response.createList(userNo, resultList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Add saving case
    @PostMapping("/add")
    public ResponseEntity<Integer> addSavings(@RequestBody SaveAccount saveAccount){
        int result = saveService.saveSaving(saveAccount);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // Update saving case
    @PostMapping("/update")
    public ResponseEntity<Integer> updateSavings(@RequestBody SaveAccount saveAccount){
        int result = saveService.updateSaving(saveAccount);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
