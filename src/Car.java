public class Car extends Vehicle{
    public int seatingcapacity;

    public Car(String vheicleId, String brand, String model, String fueltype,int seatingcapacity) {
        super(vheicleId, brand, model, fueltype);
        this.seatingcapacity = seatingcapacity;
    }

    @Override
    public double calculateRentalPrice(int duration) {
        return 20*duration*seatingcapacity*2;
    }
}
