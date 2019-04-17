package CarRental;

public class HatchBack extends Vehicle {
    public HatchBack(int vehicleNo,String model, String make, double hourlyRate){
        super(vehicleNo, model, make, true);
        this.hourlyPrice=hourlyRate;
    }

    double hourlyPrice;
    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

}
