package com.interview.java.designpatterns.parkinglot.parkingloteducative;



public abstract class ParkingSpot {

    public String number;
    public boolean free;
    public Vehicle vehicle;
    public ParkingSpotType parkingSpotType;

    public ParkingSpot(ParkingSpotType type){
        this.parkingSpotType = type;
    }

    public boolean assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.free = false;
        return true;
    }

    public boolean removeVehicle(){
        this.vehicle = null;
        this.free = true;
        return true;
    }
}
