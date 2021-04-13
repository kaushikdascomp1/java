package com.interview.java.designpatterns.bankapplication;

import java.util.List;

public class SavingsAccount extends BankAccount {


    public SavingsAccount(){
        super.setMinimumBalance(10000d);
        super.setInterestRate(4.5d);
    }

    @Override
    public synchronized boolean withdraw(Double amount) throws BankAccountException{
        return super.withdraw(amount);
    }

    @Override
    public synchronized Double deposit(Double amount) {
        return super.deposit(amount);
    }

    @Override
    public List<Transaction> getTransactionHistory() {
        return super.getTransactionHistory();
    }
}
