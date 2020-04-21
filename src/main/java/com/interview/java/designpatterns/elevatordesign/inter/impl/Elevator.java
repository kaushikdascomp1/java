package com.interview.java.designpatterns.elevatordesign.inter.impl;

import com.interview.java.designpatterns.elevatordesign.enums.ElevatorDirection;
import com.interview.java.designpatterns.elevatordesign.enums.ElevatorStatus;
import com.interview.java.designpatterns.elevatordesign.inter.ElevatorFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorFactory {

    public int currentFloor;
    public Queue<Integer> destinationFloors;

    public Elevator(int currentFloor){
        this.currentFloor = currentFloor;
        this.destinationFloors = new LinkedList<>();
    }

    public int nextDestination(){
        return this.destinationFloors.peek();
    }

    public int currentFloor(){
            return this.currentFloor;
    }

    public void popDestination(){
        this.destinationFloors.remove();
    }

    @Override
    public void moveUp() {
        currentFloor++;
    }

    @Override
    public void moveDown() {
        currentFloor--;
    }

    @Override
    public ElevatorDirection direction() {
        if(this.destinationFloors.size()>0){
            if(currentFloor < destinationFloors.peek()){
                return ElevatorDirection.UP;
            }else if(currentFloor > destinationFloors.peek()){
                return ElevatorDirection.DOWN;
            }
        }
        return ElevatorDirection.HOLD;
    }

    @Override
    public ElevatorStatus status() {
        return this.destinationFloors.size() > 0 ? ElevatorStatus.OCCUPIED : ElevatorStatus.EMPTY;
    }
}
