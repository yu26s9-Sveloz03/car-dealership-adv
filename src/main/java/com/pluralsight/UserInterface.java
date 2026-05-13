package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 = dealershipFileManager.getDealership();
        this.dealership = dealership1;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        init();
        boolean isTrue = true;
        while (isTrue){
            System.out.println("-----Dealership-----\n\t" +
                    "Please choose one:\n\t" +
                    "1 - Search by price\n\t" +
                    "2 - Search by Make & Model\n\t" +
                    "3 - Search by Year\n\t" +
                    "4 - Search by color\n\t" +
                    "5 - Search by mileage\n\t" +
                    "6 - Search by vehicle type\n\t" +
                    "7 - Show all vehicles\n\t" +
                    "8 - Add a vehicle\n\t" +
                    "9 - Remove a vehicle\n\t" +
                    "0 - Exit\n\n" +
                    "Option: ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehiclesRequest();
                case 9 -> processRemoveVehicleRequest();
                case 0 -> {
                    System.out.println("Goodbye!");
                    isTrue = false;
                }
                default -> System.out.println("Must enter a valid command");
            }
        }
    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehiclesRequest(){}

    public void processAddVehiclesRequest(){}

    public void processRemoveVehicleRequest(){}

    private void displayVehicles(ArrayList<Vehicle> vehicleArrayList) {
        for ( Vehicle vehicle: vehicleArrayList) {
            System.out.printf("VIN: %d\n" +
                    "Year: %d\n" +
                    "Make: %s\n" +
                    "Model: %s" +
                    "Vehicle Type: %s\n" +
                    "Color: %s\n" +
                    "Odometer: %d\n" +
                    "Price %.2f",vehicle.getVin(),vehicle.getYear(),
                    vehicle.getMake(),vehicle.getModel(),
                    vehicle.getVehicleType(),vehicle.getColor(),
                    vehicle.getOdometer(),vehicle.getPrice());
        }
    }

    public void processAllVehiclesRequest() {
        List<Vehicle> vehicleList = this.dealership.getAllVehicles();
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>(vehicleList);
        displayVehicles(vehicleArrayList);
    }
}
