package com.interview.java.designpatterns.sbidesign;

public class BankAccountException extends Exception {

    public BankAccountException(RuntimeException exception){
        super(exception);
    }

    public BankAccountException(String exceptionClause, RuntimeException exception){
        super(exceptionClause,exception);
    }
}
