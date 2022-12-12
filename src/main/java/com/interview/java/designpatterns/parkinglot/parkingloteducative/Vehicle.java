package com.interview.java.designpatterns.parkinglot.parkingloteducative;

public abstract class Vehicle {

    public String licenceNo;
    public VehicleType vehicleType;
    public ParkingTicket parkingTicket;

    public Vehicle(VehicleType type){
        this.vehicleType = type;
    }

    public void assignTicket(ParkingTicket parkingTicket){
        this.parkingTicket =parkingTicket;
    }

}
