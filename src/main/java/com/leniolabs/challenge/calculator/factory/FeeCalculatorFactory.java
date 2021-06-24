package com.leniolabs.challenge.calculator.factory;

import com.leniolabs.challenge.calculator.CorporateAccountFeeCalculator;
import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import com.leniolabs.challenge.calculator.PersonalAccountFeeCalculator;
import com.leniolabs.challenge.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeeCalculatorFactory {

    @Autowired
    private PersonalAccountFeeCalculator personalCalculator;

    @Autowired
    private CorporateAccountFeeCalculator corporateCalculator;

    public FeeCalculatorIF getCalculator(Account account) {
        if (account.getAccountType().equals("personal")) {
            return personalCalculator;
        }
        if (account.getAccountType().equals("corporate")) {
            return corporateCalculator;
        }
        return null;

    }
}
