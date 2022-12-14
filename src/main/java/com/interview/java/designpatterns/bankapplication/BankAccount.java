package com.interview.java.designpatterns.bankapplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public abstract class BankAccount {


    private String accountNumber;
    private volatile Double minimumBalance;
    private volatile Double currentBalance;

    private Double interestRate;


    private List<Transaction> transactions;


    public  boolean withdraw(Double amount) throws BankAccountException{
        Double amountLeft = this.getCurrentBalance() - amount;

        if(amountLeft < getMinimumBalance()){
            throw new BankAccountException("Current Balance is less than minimum balance:: ",new RuntimeException());
        }
        setCurrentBalance(amountLeft);
        return true;
    }

    public synchronized Double deposit(Double amount){
        Double amountdeposited = this.getCurrentBalance() + amount;
        setCurrentBalance(amountdeposited);
        return amountdeposited;
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }



    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
