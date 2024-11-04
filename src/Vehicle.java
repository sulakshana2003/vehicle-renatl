public abstract class Vehicle {
    private String VheicleId;
    private String brand;
    private String model;
    private String fueltype;

    public Vehicle(String vheicleId, String brand, String model, String fueltype) {
        VheicleId = vheicleId;
        this.brand = brand;
        this.model = model;
        this.fueltype = fueltype;
    }
    public String getVehicleinfo(){
        return brand+ " "+ model;
    }
    public abstract double calculateRentalPrice(int duration);
}
