package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

    // ATTRIBUTES
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    // CONSTRUCTOR
    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address =  address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    // <editor-fold desc="GETTERS/SETTERS">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
// </editor-fold>

// <editor-fold desc="DERIVED GETTERS">

    public List<Vehicle> getVehiclesByPrice(double min, double max){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose price is between the min and max
        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose make and model match those provided
        for (Vehicle vehicle : inventory){
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose year is between the min and max
        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;

    }

    public List<Vehicle> getVehiclesByColor(String color){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose make and model match those provided
        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().equals(color)){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;

    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose odometer reading is between the min and max
        for (Vehicle vehicle : inventory){
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;

    }

    public List<Vehicle> getVehiclesByType(String vehicleType){

        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();

        // Adds to filtered list every vehicle in inventory whose type of vehicle match the one provided
        for (Vehicle vehicle : inventory){
            if (vehicle.getVehicleType().equals(vehicleType)){
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

// </editor-fold>

    // MORE METHODS
    public void addVehicle(Vehicle vehicle){

        // Adds vehicle to array of vehicles
        inventory.add(vehicle);

        // Initiates DealershipFileManager object
        DealershipFileManager fileManager = new DealershipFileManager();

        // Updates file with current dealership (array of vehicles)
        fileManager.saveDealership(this);

    }

    public void removeVehicle(Vehicle vehicle){

        // Removes vehicle from array of vehicles
        inventory.remove(vehicle);

        // Initiates DealershipFileManager object
        DealershipFileManager fileManager = new DealershipFileManager();

        // Updates file with current dealership (array of vehicles)
        fileManager.saveDealership(this);
    }

}