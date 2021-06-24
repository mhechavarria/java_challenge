package com.leniolabs.challenge.calculator.factory;

import com.leniolabs.challenge.calculator.FeeCalculatorIF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FeeCalculatorFactory {

    @Autowired
    @Qualifier("corporate")
    private FeeCalculatorIF calculator;
    // TO DO: Develop factory class logic

}
