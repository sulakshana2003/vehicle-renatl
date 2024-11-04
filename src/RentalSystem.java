import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalSystem {
    private static ArrayList<Rental> rental = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RentalSystem ren = new RentalSystem();
        boolean rentalvehi = true;
        String firstchoice;

        while (rentalvehi){
                while(true){
                    try{
                        System.out.print("what do you want to rent (car or bike) or 'exit 'to finish: ");
                        firstchoice = scanner.nextLine();
                        if(!firstchoice.equalsIgnoreCase("car")&&!firstchoice.equalsIgnoreCase("bike")&&!firstchoice.equalsIgnoreCase("exit")) throw new CheckCarOrBike("if you want to choose vehicle choose one (car or bike)");
                        break;
                    }catch (CheckCarOrBike e){
                        System.out.println(e.getMessage());
                    }
                }

                if(firstchoice.equalsIgnoreCase("exit")) {
                    rentalvehi = false;
                    break;
                }
                Vehicle vehicle = createVehicle(firstchoice);
                if (vehicle != null){
                    System.out.print("Enter customer name: ");
                    String cusName = scanner.nextLine();
                    int duration = durationOfrental();
                    Rental rentals = new Rental(cusName,duration,vehicle);
                    rental.add(rentals);
                    System.out.println("Rental for "+ vehicle.getVehicleinfo()+" added successfully!\n");
                }else {
                    System.out.println("invalid vehicle!");
                }

        }//while
        displayAlldetails();
        scanner.close();

    }// main function
    private static Vehicle createVehicle(String vehicletype){
        String name , brand,model,fuelType;
            while(true){
                try{
                    System.out.print("Enter Vehicle ID: ");
                    name = scanner.nextLine();
                    if(name.isEmpty()) throw new IllegalArgumentException("Enter id!");
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
            }
        while(true){
            try{
                System.out.print("Enter Vehicle Brand: ");
                brand = scanner.nextLine();
                if(brand.isEmpty()) throw new IllegalArgumentException("Enter id!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.print("Enter Vehicle model: ");
                model = scanner.nextLine();
                if(model.isEmpty()) throw new IllegalArgumentException("Enter id!");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
            while(true){
                try{
                    System.out.print("Enter Vehicle Fueltype: ");
                    fuelType = scanner.nextLine();
                    if(!fuelType.equalsIgnoreCase("gas")&&!fuelType.equalsIgnoreCase("hybrid")) throw new GasType("Not a valid fuel type");
                    break;
                }catch (GasType e) {
                        System.out.println(e.getMessage());
                    }
        }
        int seats;
        if(vehicletype.equalsIgnoreCase("car")){
            while(true){
                try{
                    System.out.print("Enter seating capacity: ");
                    seats = scanner.nextInt();
                    scanner.nextLine();
                    if(seats<=0 || seats>8) throw new invalidSeatnombers("Enter possible seats(0-8)");
                    break;
                } catch (invalidSeatnombers e) {
                    System.out.println(e);
                }
            }
            return new Car(name,brand,model,fuelType,seats);
        }
        String answer;
        boolean helmet;
        if(vehicletype.equalsIgnoreCase("bike")){
            while(true){
                try{
                    System.out.print("Helmet provide (yes or no): ");
                    answer = scanner.nextLine();
                    if(!answer.equalsIgnoreCase("yes")&&!answer.equalsIgnoreCase("no")) throw new invalidHelmet("Enter YES or No");
                    break;
                }catch (invalidHelmet e){
                    System.out.println(e.getMessage());
                }
            }

            helmet = answer.equalsIgnoreCase("yes");
            return new Bike(name,brand,model,fuelType,helmet);
        }
        return null;
    }//vehicle type

    private static int durationOfrental() throws InvalidRentalDurationException{
        int duration;
        while(true){
            try{
                System.out.print("Enter Rental duration: ");
                duration = scanner.nextInt();
                scanner.nextLine();
                if(duration <= 0) throw new InvalidRentalDurationException("Error: Invalid duration time!");
                return duration;
            } catch (InvalidRentalDurationException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e + "invalid input. please enter number");
            }
        }
    }
    private static void displayAlldetails() {
        if(!rental.isEmpty()){
            System.out.println("-----All Rental Details------");
            for (int i = 0; i < rental.size(); i++) {
                System.out.println("-----Rentel " + (i+1) + "----------");
                System.out.println(rental.get(i).rentalDetails());
            }
        }else{
            System.out.println("There is no Records!");
        }

    }
}//main class
