package CarRental;

public class Booked {

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public void setPeriod(TimePeriod period) {
        this.period = period;
    }

    Vehicle vehicle;
    TimePeriod period;

    public Booked(Vehicle vehicle, TimePeriod period){
        this.vehicle=vehicle;
        this.period=period;

    }

}
