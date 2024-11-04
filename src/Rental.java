public class Rental {
    private String name ;
    private int Rentalhours;
    private Vehicle vehicle;
    private double rentalPrice;

    public Rental(String name, int rentalhours, Vehicle vehicle) {
        this.name = name;
        Rentalhours = rentalhours;
        this.vehicle = vehicle;
        this.rentalPrice = vehicle.calculateRentalPrice(rentalhours);
    }

    public String rentalDetails(){
        return "Customer name: "+name+"\n"+
                "Vehicle: "+ vehicle.getVehicleinfo() +"("+vehicle.getClass().getSimpleName()+")\n"+
                "Duration: "+Rentalhours+" hours\n"+
                "Rental Price: $"+rentalPrice;

    }
}
