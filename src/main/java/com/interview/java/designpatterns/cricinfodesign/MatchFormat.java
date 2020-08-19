package com.interview.java.designpatterns.cricinfodesign;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum MatchFormat {

    ODI(50,2),
    T20(20,2),
    TEST(450,4);

    private int numberOfOvers;
    private int numberOfInnings;


    MatchFormat(int numberOfOvers, int numberOfInnings){
        this.numberOfOvers = numberOfOvers;
        this.numberOfInnings = numberOfInnings;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public void setNumberOfInnings(int numberOfInnings) {
        this.numberOfInnings = numberOfInnings;
    }
}
