package com.interview.java.designpatterns.elevatordesign.inter.impl;

import com.interview.java.designpatterns.elevatordesign.enums.ElevatorDirection;
import com.interview.java.designpatterns.elevatordesign.inter.ElevatorControlSystemFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorControlSystem implements ElevatorControlSystemFactory {

    public static final int MAX_ELEVATORS = 16;

    public int numberOfElevators = 0;
    public int numberOfFloors = 0;
    public List<Elevator> elevators;
    public Queue<Integer> pickUpLocations;

    public ElevatorControlSystem(int numberOfElevators, int numberOfFloors){
        if (numberOfElevators<0)
            throw new IllegalArgumentException("Elevator Number Should be positive::  ");
        if(numberOfElevators < MAX_ELEVATORS)
            this.numberOfElevators = numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        pickUpLocations = new LinkedList<>();
        initializeElevator();
    }

    public void initializeElevator(){
        elevators = new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            elevators.add(new Elevator(1));
        }
    }

    public List<Elevator> getElevators(){
        return elevators;
    }

    @Override
    public void pickUp(int pickUpFloor) {
        pickUpLocations.add(pickUpFloor);

    }

    @Override
    public void destination(int elevatorId, int destinationFloor) {
            this.elevators.get(elevatorId).destinationFloors.add(destinationFloor);
    }

    @Override
    public void step() {
        for(Elevator currElevator : elevators){
            switch (currElevator.status()){
                case EMPTY:
                    if(!pickUpLocations.isEmpty())
                        currElevator.destinationFloors.add(pickUpLocations.poll());
                    break;
                case OCCUPIED:
                    switch (currElevator.direction()) {
                        case UP:
                            currElevator.moveUp();
                            break;
                        case DOWN:
                            currElevator.moveDown();
                            break;
                        case HOLD:
                            // TODO: Check timer here to alert users that they are holding the door open to long
                            // TODO: Emergency situation where elevator can't be used
                            // TODO: Maintenance Mode e.g. movers or maintenance people
                            currElevator.popDestination();
                            break;
                    }
                    if(currElevator.direction() == ElevatorDirection.UP)
                        break;

            }
        }
    }
}
