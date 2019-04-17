package CarRental;

public class Reservation {

    String customerName;
    int hours;
    int day;
    int month;
    int year;
    int vehicleNo;
    Vehicle vehicle;
    public Reservation(String customerName, int hours, int vehicleNo, Vehicle vehicle){
        this.customerName=customerName;
        this.hours=hours;
        this.vehicleNo=vehicleNo;
        this.vehicle = vehicle;
        }
}
