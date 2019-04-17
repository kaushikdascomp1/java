package CarRental;

public class Vehicle {

    int vehicleNo;
    String model;
    String make;
    boolean fuelType;

    public Vehicle(){

    }

    public Vehicle(int vehicleNo, String model, String make, boolean fuelType){
        this.vehicleNo=vehicleNo;
        this.model=model;
        this.make=make;
        this.fuelType=fuelType;

    }
    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isFuelType() {
        return fuelType;
    }

    public void setFuelType(boolean fuelType) {
        this.fuelType = fuelType;
    }






}
