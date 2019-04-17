package CarRental;

public class Sedan extends Vehicle{

    int numSeats;

    double hourlyPrice;


    public Sedan(int vehicleNo,String model, String make, double hourlyRate){
        super(vehicleNo, model, make, true);
        this.hourlyPrice=hourlyRate;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }


}
