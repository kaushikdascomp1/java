package com.interview.java.designpatterns.vendingmachine.payment.paymentstrategy;

import com.interview.java.designpatterns.vendingmachine.payment.Payment;

public class UPIPayment implements Payment {


    @Override
    public boolean doPayment( int amout) {
        //implement payment methods for UPI
        return true;
    }
}
