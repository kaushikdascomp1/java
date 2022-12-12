package com.interview.java.designpatterns.parkinglot.parkingloteducative;

public abstract class Account {

    public String userName;
    public String password;
    public AccountStatus accountStatus;
    public Person person;

    public abstract boolean resetPassword();
}
