package com.interview.java.designpatterns.parkinglot;

public class Motorcycle extends Vehicle{

    public Motorcycle(String licensePlate, String Company){
        spotsNeeded = 1;
        size = VehicleSize.MOTORBIKE;
        this.licensePlate = licensePlate;
        this.Company = Company;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        //checks if the spot is a compact, motorcycle or a large

        return spot.getSize() == VehicleSize.CAR || spot.getSize() == VehicleSize.MOTORBIKE;

    }
}
