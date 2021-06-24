package com.leniolabs.challenge.service;

import com.leniolabs.challenge.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccounServiceIF {

    public String createAccount(Account account);

    public List<Account> getAccounts();

    public Optional<Account> getAccountById(String id);

    public int deleteAccountById(String id);

}
