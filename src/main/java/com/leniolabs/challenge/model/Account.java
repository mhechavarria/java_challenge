package com.leniolabs.challenge.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    private String id;
    private String name;
    private String lastName;
    private String accountType;
    private Double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("lastName") String lastName, @JsonProperty("accountType") String accountType,
            @JsonProperty("balance") Double balance) {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        this.name = name;
        this.lastName = lastName;
        this.accountType = accountType;
        this.balance = balance;
    }

}
