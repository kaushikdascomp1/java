package com.interview.java.designpatterns.bankapplication;

import java.util.List;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(){
        super.setMinimumBalance(20000d);
        super.setInterestRate(0d);
    }



    private Transaction lock = new Transaction();

    @Override
    public synchronized boolean withdraw(Double amount) throws BankAccountException {
        synchronized (lock){

        }
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


