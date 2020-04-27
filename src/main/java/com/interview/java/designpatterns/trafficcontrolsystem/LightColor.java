package com.interview.java.designpatterns.trafficcontrolsystem;

public enum LightColor {

    RED(10),
    YELLOW(2),
    GREEN(10);

    public int durationInSeconds;

    LightColor(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }



}
