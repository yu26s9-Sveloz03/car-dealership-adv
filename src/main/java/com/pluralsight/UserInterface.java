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

    public void processGetByPriceRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the smallest price?");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("What is the biggest price?");
        double max = scanner.nextDouble();
        scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicleList);
    }

    public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the make?");
        String make = scanner.nextLine();
        System.out.println("What is the model?");
        String model = scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByMake(make, model);
        displayVehicles(vehicleList);
    }

    public void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the earliest year?");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("What is the latest year?");
        double max = scanner.nextDouble();
        scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicleList);
    }

    public void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the color?");
        String color = scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
        displayVehicles(vehicleList);
    }

    public void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the lowest mileage?");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is the highest mileage?");
        int max = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicleList);
    }

    public void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the vehicle type?");
        String vehicleType = scanner.nextLine();
        ArrayList<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicleList);
    }

    public void processGetAllVehiclesRequest(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicleList = dealership.getAllVehicles();
        displayVehicles(vehicleList);
    }

    public void processAddVehiclesRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the VIN number?");
        String vin = scanner.nextLine();
        System.out.println("What is the year?");
        String year = scanner.nextLine();
        System.out.println("What is the make?");
        String make = scanner.nextLine();
        System.out.println("What is the model?");
        String model = scanner.nextLine();
        System.out.println("What is the vehicle type?");
        String vehicleType = scanner.nextLine();
        System.out.println("What is the color?");
        String color = scanner.nextLine();
        System.out.println("What is the mileage?");
        String odometer = scanner.nextLine();
        System.out.println("What is the price?");
        String price = scanner.nextLine();
        Vehicle vehicle = new Vehicle(Integer.parseInt(vin),Integer.parseInt(year),make,model,vehicleType,color,Integer.parseInt(odometer),Double.parseDouble(price));
        dealership.addVehicle(vehicle);
    }

    public void processRemoveVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicleArrayList) {
        for ( Vehicle vehicle: vehicleArrayList) {
            System.out.printf("VIN: %d\n" +
                    "Year: %d\n" +
                    "Make: %s\n" +
                    "Model: %s\n" +
                    "Vehicle Type: %s\n" +
                    "Color: %s\n" +
                    "Odometer: %d\n" +
                    "Price %.2f\n\n",vehicle.getVin(),vehicle.getYear(),
                    vehicle.getMake(),vehicle.getModel(),
                    vehicle.getVehicleType(),vehicle.getColor(),
                    vehicle.getOdometer(),vehicle.getPrice());
        }
    }

    public void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicleList = this.dealership.getAllVehicles();
        displayVehicles(vehicleList);
    }
}
