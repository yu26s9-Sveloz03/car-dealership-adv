package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {


    public Dealership getDealership() {
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstLine = bufferedReader.readLine();
            String[] dealershipInfo = firstLine.split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0],dealershipInfo[1],dealershipInfo[2]);
            while ((firstLine = bufferedReader.readLine()) != null){
                String[] vehicleLine = firstLine.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleLine[0]),Integer.parseInt(vehicleLine[1]),
                        vehicleLine[2],vehicleLine[3],vehicleLine[4],vehicleLine[5],
                        Integer.parseInt(vehicleLine[6]),Double.parseDouble(vehicleLine[7]));
                dealership.addVehicle(vehicle);
            }
            return dealership;
        } catch (Exception e) {
            System.out.println("Can't find the file.");
            return new Dealership("","","");
        }
    }

    public void saveDealership(Dealership dealership) {}
}
