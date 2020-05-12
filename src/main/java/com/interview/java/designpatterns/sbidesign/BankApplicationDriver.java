package com.interview.java.designpatterns.sbidesign;

public class BankApplicationDriver {

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        System.out.println(savingsAccount.getMinimumBalance());;
    }
}
