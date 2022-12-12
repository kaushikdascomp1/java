package com.interview.arrays.overlappingsubproblems;

import java.util.Arrays;

public class HotelBookingsPossible {

    //A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms.
    // Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
    // Write a program that solves this problem in time O(N log N) .

    public static void main(String[] args) {
        int[] arrival = {1, 3, 7};
        int[] departure = {2, 6, 8};
        System.out.println(findBookings(arrival,departure,1));
    }

    public static boolean findBookings(int[] arrival, int[] departure,int k){

        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i=0, j=0, roomsRequired=0;
        while(i<arrival.length && j<departure.length && roomsRequired<=k){
            if(arrival[i]<departure[j]){
                roomsRequired++;
                i++;
            }else{
                roomsRequired--;
                j++;
            }
        }
        if(roomsRequired<=k)
            return true;

        return false;

    }
}
