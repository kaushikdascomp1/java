package com.interview.java.designpatterns.bankapplication;

public class BankAccountException extends Exception {

    public BankAccountException(RuntimeException exception){
        super(exception);
    }

    public BankAccountException(String exceptionClause, RuntimeException exception){
        super(exceptionClause,exception);
    }
}
