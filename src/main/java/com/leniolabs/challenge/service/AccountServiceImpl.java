package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccounServiceIF {

    private static List<Account> accounts = new ArrayList<>();

    @Override
    public String createAccount(Account account) {
        accounts.add(account);
        return account.getId();
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public Optional<Account> getAccountById(String id) {
        return accounts.stream().filter(account -> account.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteAccountById(String id) {
        Optional<Account> existingAccount = getAccountById(id);
        if (existingAccount.isPresent()) {
            accounts.remove(existingAccount.get());
            return 1;
        }
        return 0;
    }
}
