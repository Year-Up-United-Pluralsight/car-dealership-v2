package com.pluralsight;
import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership(){

        try {

            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Gets dealership info in first line
            String firstLine = bufferedReader.readLine();
            String[] dealershipParamInfo = firstLine.split("\\|");

            // Creates new dealership using dealership info
            Dealership dealership = new Dealership(dealershipParamInfo[0], dealershipParamInfo[1], dealershipParamInfo[2]);

            String line;

            while((line = bufferedReader.readLine()) != null){

                // Splits input by pipe
                String[] vehicleElements = line.split("\\|");

                // Converts each element into its proper type
                int vin = Integer.parseInt(vehicleElements[0]);
                int year = Integer.parseInt(vehicleElements[1]);
                String make = vehicleElements[2];
                String model = vehicleElements[3];
                String vehicleType = vehicleElements[4];
                String color = vehicleElements[5];
                int odometer = Integer.parseInt(vehicleElements[6]);
                double price = Double.parseDouble(vehicleElements[7]);

                // Constructs a vehicle object
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                // Adds the newly made vehicle to the dealership object
                dealership.addVehicle(vehicle);
            }

            bufferedReader.close();

            return dealership;
        }

        catch (IOException e){
            System.out.println("Error! File failed to read...");
            return null;
        }

    }

    public void saveDealership(Dealership dealership){

        try {

            // "true" in order to append to file instead of replace
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(dealership.getName() + "|");
            bufferedWriter.write(dealership.getAddress() + "|");
            bufferedWriter.write(dealership.getPhone());

            // Updates the file by writing every vehicle's attributes in dealership to the file in order separated by a pipe
            for (Vehicle vehicle : dealership.getAllVehicles()){

                bufferedWriter.write("\n"); // Skips a line
                bufferedWriter.write(vehicle.getVin() + "|");
                bufferedWriter.write(vehicle.getYear() + "|");
                bufferedWriter.write(vehicle.getMake() + "|");
                bufferedWriter.write(vehicle.getModel() + "|");
                bufferedWriter.write(vehicle.getVehicleType() + "|");
                bufferedWriter.write(vehicle.getColor() + "|");
                bufferedWriter.write(vehicle.getOdometer() + "|");
                bufferedWriter.write(String.format("%.2f", vehicle.getPrice()));
            }

            bufferedWriter.close();

        }

        catch (IOException e){
            System.out.println("Error! File failed to read...");
        }

    }

}
