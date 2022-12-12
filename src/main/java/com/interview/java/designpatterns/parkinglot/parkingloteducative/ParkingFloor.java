package com.interview.java.designpatterns.parkinglot.parkingloteducative;

import java.util.Map;

public class ParkingFloor {

    String name;
    Map<String, HandicappedSpot> handicappedSpotMap;
    Map<String, CompactSpot> compactSpotMap;
    Map<String, Electric> electricSpotMap;

    public ParkingFloor(String name){
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot){
        switch (spot.parkingSpotType){
            case HANDICAPPED:
                handicappedSpotMap.put(spot.number, new HandicappedSpot());
                break;
            case COMPACT:
                compactSpotMap.put(spot.number, new CompactSpot());
                break;
            case ELECTRIC:
                electricSpotMap.put(spot.number, new Electric());
                break;
            default:
                System.out.println("Wrong Parking spot");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot){
        spot.assignVehicle(vehicle);

    }
}
