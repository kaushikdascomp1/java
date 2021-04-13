package com.interview.java.designpatterns.cricinfodesign;

import lombok.Getter;

@Getter
public enum BowlTypes {

    NO_BALL(1,0),
    WIDE_BALL(1,0),
    DEAD_BALL(0,0),
    SINGLE(1,1),
    DOUBLE(2,1),
    TRIPLE(3,1),
    FOUR(4,1),
    SIX(6,1),
    WICKETS(0,1);

    private int runsGiven;
    private int bowlConsumed;

     BowlTypes(int runsGiven, int bowlConsumed){
        this.runsGiven = runsGiven;
        this.bowlConsumed = bowlConsumed;
    }
}
