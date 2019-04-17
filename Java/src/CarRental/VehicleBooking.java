package CarRental;

import java.util.ArrayList;
import java.util.List;

public class VehicleBooking {



    public static void main(String[] args) {
        VehicleBooking vehicleBooking = new VehicleBooking();
        List<Booked> unAvailableList = new ArrayList<>();

        List<Booked> availableBookings = new ArrayList<>();

        Vehicle vehicle = new Sedan(12,"City","Honda",150 );

        availableBookings.add(new Booked(vehicle,null));
        availableBookings.add(new Booked(new HatchBack(123,"Alto","Maruti",80 ),null));
        availableBookings.add(new Booked(new Sedan(124,"Amaze","Honda",120 ),null));
        vehicleBooking.displayAvailable(availableBookings);
        // Create Reservation
        vehicleBooking.createReservation(new Sedan(124,"Amaze","Honda",120 ), new TimePeriod(23,12,9, 2019),availableBookings,unAvailableList );

    }

    public void displayAvailable(List<Booked> booked){
        for(int i=0;i<booked.size();i++){
            System.out.println("Cars Availble :" + booked.get(i).getVehicle().make+ ": For Time" + booked.get(i).getPeriod());
        }
    }

    public void createReservation(Vehicle vehicle, TimePeriod period, List<Booked> availableBookings, List<Booked> unavailableBookings ){
            Booked booked = new Booked(vehicle,period);
            boolean isAvialable = checkAvailable(booked, availableBookings);

            if(isAvialable && period.month<30){
                availableBookings.remove(booked);
            }else {
                unavailableBookings.add(booked);
            }
    }


    boolean checkAvailable(Booked booking, List<Booked> booked){

        for(Booked book : booked ){
            if(book.getVehicle().make.equals(booking.getVehicle().getMake()) && book.getVehicle().vehicleNo==booking.getVehicle().vehicleNo && book.getPeriod().day == booking.getPeriod().day && book.getPeriod().month == booking.getPeriod().month && book.getPeriod().time == booking.getPeriod().time && book.getPeriod().year==booking.getPeriod().year){
               return false;
            }
        }
        return true;
    }



}
