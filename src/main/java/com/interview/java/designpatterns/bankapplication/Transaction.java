package com.interview.java.designpatterns.bankapplication;

import javax.persistence.*;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tranactionId;
    @Column
    private double amount;
    @Column
    private String type;

    public String getTranactionId() {
        return tranactionId;
    }

    public void setTranactionId(String tranactionId) {
        this.tranactionId = tranactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
