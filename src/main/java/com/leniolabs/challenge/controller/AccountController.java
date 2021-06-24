package com.leniolabs.challenge.controller;

import java.util.List;
import java.util.Optional;

import com.leniolabs.challenge.calculator.factory.FeeCalculatorFactory;
import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.service.AccounServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lenio-challenge/account/v1")
public class AccountController {

    @Autowired
    private AccounServiceIF accountControllerService;

    @Autowired
    private FeeCalculatorFactory feeCalculatorFactory;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        String accountId = accountControllerService.createAccount(account);
        return ResponseEntity.ok(accountId);
    }

    @GetMapping(value = "/calculate-fee/{id}")
    public ResponseEntity<Double> calculateFee(@PathVariable String id) throws Exception {
        // TO DO: develop return logic
        return null;
    }

    @GetMapping(value = "/getAll")
    public List<Account> getAccounts() {
        return accountControllerService.getAccounts();
    }

    @GetMapping(value = "/getAccountById/{id}")
    public Optional<Account> getAccountById(@PathVariable String id) throws Exception {
        // TO DO: develop return logic
        return accountControllerService.getAccount(id);
    }
}
