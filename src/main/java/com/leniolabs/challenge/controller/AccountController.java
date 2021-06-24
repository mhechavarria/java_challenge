package com.leniolabs.challenge.controller;

import java.util.List;
import java.util.Optional;

import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import com.leniolabs.challenge.calculator.factory.FeeCalculatorFactory;
import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.service.AccounServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Double> calculateFee(@PathVariable String id) {
        Optional<Account> existingAccount = accountControllerService.getAccountById(id);
        if (existingAccount.isPresent()) {
            FeeCalculatorIF calculator = feeCalculatorFactory.getCalculator(existingAccount.get());
            Double fee = calculator.calculateFee();
            return ResponseEntity.ok(fee);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping(value = "/getAll")
    public List<Account> getAccounts() {
        return accountControllerService.getAccounts();
    }

    @GetMapping(value = "/getAccountById/{id}")
    public Optional<Account> getAccountById(@PathVariable String id) throws Exception {
        return accountControllerService.getAccountById(id);
    }

    @DeleteMapping(value = "/deleteAccountById/{id}")
    public void deleteAccountById(@PathVariable String id) throws Exception {
        accountControllerService.deleteAccountById(id);
    }
}
