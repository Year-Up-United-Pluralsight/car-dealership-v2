package com.pluralsight;

public class Program {
    public static void main(String[] args) {


        // INITIALIZES TEST DEALERSHIP FILE MANAGER OBJECT
        DealershipFileManager fileManager = new DealershipFileManager();

        // TESTS FOR ADD/REMOVE METHODS
        Dealership myDealership = fileManager.getDealership();
//
//        myDealership.addVehicle(new Vehicle(7654321, 1993, "Honda", "Odyssey", "SUV", "Green", 1234567, 100000.00));
        myDealership.removeVehicle(myDealership.getAllVehicles().get(myDealership.getAllVehicles().size() - 2)); // Removes last vehicle entry

        UserInterface userInterface = new UserInterface();
        userInterface.display();

    }
}