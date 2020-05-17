package com.interview.java.designpatterns.bankapplication;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Transaction {

    private AtomicInteger tranactionId;
    private double amount;
    private String type;

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public AtomicInteger getTranactionId() {
        return tranactionId;
    }

    public class TransactionBuilder{
        //Required parameter
        private AtomicInteger tranactionId;

        //Optional parameters
        private double amount;
        private String type;

        public TransactionBuilder(AtomicInteger tranactionId){
            this.tranactionId = tranactionId;
        }

        public TransactionBuilder withAmount(double amount){
            this.amount = amount;
            return this;
        }

        public TransactionBuilder withType(String type){
            this.type = type;
            return this;
        }

        public Transaction build(){
            if(null == tranactionId){
                throw new IllegalArgumentException("Transaction Id cannot be null:: ");
            }
            return new Transaction(this);
        }

    }

    public Transaction(TransactionBuilder builder){
        this.tranactionId = builder.tranactionId;
        this.amount = builder.amount;
        this.type = builder.type;
    }



}
