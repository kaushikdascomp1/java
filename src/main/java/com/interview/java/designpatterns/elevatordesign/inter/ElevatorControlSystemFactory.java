package com.interview.java.designpatterns.elevatordesign.inter;

public interface ElevatorControlSystemFactory {

    void pickUp(int pickUpFloor);
    void destination(int elevatorId,int destinationFloor);
    void step();
}
