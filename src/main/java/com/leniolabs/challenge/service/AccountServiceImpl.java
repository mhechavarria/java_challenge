package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccounServiceIF {

    private static List<Account> accounts = new ArrayList<>();

    @Override
    public String createAccount(Account account) {
        accounts.add(account);
        return account.getId();
    }
}
