package com.interview.java.designpatterns.elevatordesign.inter;

import com.interview.java.designpatterns.elevatordesign.enums.ElevatorDirection;
import com.interview.java.designpatterns.elevatordesign.enums.ElevatorStatus;

public interface ElevatorFactory {

    void moveUp();
    void moveDown();
    ElevatorDirection direction();
    ElevatorStatus status();
}
