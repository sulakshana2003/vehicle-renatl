public class Bike extends Vehicle {
    public boolean hashelmet;

    public Bike(String vheicleId, String brand, String model, String fueltype, boolean hashelmet) {
        super(vheicleId, brand, model, fueltype);
        this.hashelmet = hashelmet;
    }

    @Override
    public double calculateRentalPrice(int duration) {
        return 15*duration*(hashelmet?5:1);
    }
}
