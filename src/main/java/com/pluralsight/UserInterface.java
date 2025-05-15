package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface(){
    }

    // Loads in the dealership
    private void init(){

        // Creates an instance of DealershipFileManager class
        DealershipFileManager fileManager = new DealershipFileManager();

        // Assigns dealership object to the UserInterface's this.dealership attribute
        this.dealership = fileManager.getDealership();

    }

    public void display() {

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Loads in the dealership
        init();

        int userChoice;

        System.out.println("=========== WELCOME TO DIN'S CAR DEALERSHIP! ===========");

        // Displays menu, takes user input, & calls corresponding process() method; exits if user chooses exit or enters nothing
        do {

            // Displays the menu
            System.out.print("""
            ~ Please select an option to search by...
                (1) Price Range
                (2) Make & Model
                (3) Year Range
                (4) Color
                (5) Mileage Range
                (6) Type
                (7) All Vehicles
                (8) Add Vehicles
                (9) Remove Vehicles
                (99) Quit
                
            ~ Enter your choice here ➤\s""");

            // Read's user choice
            userChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.println(); //Skip line

            // Switch statement that calls the correct process() method that matches the user request
            switch(userChoice) {
                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                case 99:
                    System.out.println("~ Have a good day!");
                    break;
            }

        } while (userChoice != 7 && userChoice != 0);
    }

// DERIVED GETTER METHODS
    public void processGetByPriceRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a minimum price: ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Please enter a maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));

    };

    public void processGetByMakeModelRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a make: ");
        String makeInput = scanner.nextLine();

        System.out.print("Please enter a model: ");
        String modelInput = scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByMakeModel(makeInput, modelInput));
    };

    public void processGetByYearRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a minimum year: ");
        int minYear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter a maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    };

    public void processGetByColorRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a color: ");
        String colorInput = scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByColor(colorInput));

    }

    public void processGetByMileageRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a minimum mileage: ");
        int minMileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter a maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));

    };

    public void processGetByVehicleTypeRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.print("Please enter a vehicle type: ");
        String typeInput = scanner.nextLine();
        System.out.println(); //Skip line

        // Filters based on user input
        displayVehicles(dealership.getVehiclesByType(typeInput));

    };

    public void processGetAllVehiclesRequest(){ displayVehicles(dealership.getAllVehicles()); };

    public void processAddVehicleRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.println("Please enter the details below to the vehicle you would like to add...");

        // <editor-fold desc="USER PROMPTS FOR VEHICLE ATTRIBUTES">
        System.out.print("VIN #: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        // </editor-fold> FOR V

        // Constructs vehicle object using vehicle details from user input
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Initializes dealership manager object; calls addVehicle to add user's vehicle
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.getDealership().addVehicle(vehicle);

    };

    public void processRemoveVehicleRequest(){

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Gets user input
        System.out.println("Please enter the details below to the vehicle you would like to add...");

        System.out.print("Please enter the vehicle's VIN #: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        
        // Constructs vehicle object using vehicle details from user input
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Initializes dealership manager object; calls addVehicle to add user's vehicle
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.getDealership().removeVehicle(vehicle);

    };


    private void displayVehicles(List<Vehicle> vehicles){

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", "VIN", "YEAR", "MAKE", "MODEL", "TYPE",
                "COLOR", "ODOMETER", "PRICE");

        // Prints every vehicle in the inputted list of vehicles
        for(Vehicle vehicle : vehicles){

            System.out.printf("%-10d %-10d %-10s %-10s %-10s %-10s %-10d %-10f%n",vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
                    vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice());
        }

        System.out.println(); // Skip a line
    }

}