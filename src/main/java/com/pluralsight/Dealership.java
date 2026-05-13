package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByMake(String make, String model) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equalsIgnoreCase(color)){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.addAll(this.inventory);
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

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
}
