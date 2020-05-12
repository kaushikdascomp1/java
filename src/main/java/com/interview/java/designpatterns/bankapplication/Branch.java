package com.interview.java.designpatterns.bankapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Branch {

    public static Logger logger = LoggerFactory.getLogger(Branch.class);

    private List<BankAccount> bankAccounts;
    private List<Customer> customers;
    private String branchId;

    public String getBranchId(){
        return branchId;
    }

    public BankAccount getAccountByAccountNumber(String accountNumber) throws BankAccountException {
        for(BankAccount account: bankAccounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }else {
                logger.info("Account Number not found:: "+accountNumber);
                throw new BankAccountException("Account Number not found:: ",new RuntimeException());
            }
        }
        return null;
    }

    public Customer getCustomerByPanNumber(String panNumber) throws BankAccountException {
        for(Customer customer:customers){
            if (customer.getPanNumber().equals(panNumber)){
                return customer;
            }else {
                logger.info("Customer Details not found:: "+panNumber);
                throw new BankAccountException("Customer Details not found:: ",new RuntimeException());
            }
        }
        return null;
    }

    public boolean createBankAccount(String panNumber, String type, Double amount){
        BankAccount account;
        if(type.equals("Savings")){
            account = new SavingsAccount();

        }else {
            account = new CurrentAccount();
        }
        bankAccounts.add(account);
        return true;

    }



}
