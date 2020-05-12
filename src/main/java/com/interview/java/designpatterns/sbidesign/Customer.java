package com.interview.java.designpatterns.sbidesign;

import java.util.List;

public class Customer {

    private List<BankAccount> accounts;
    private String panNumber;

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
