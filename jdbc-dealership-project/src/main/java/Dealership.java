package com.pluralsight

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<org.example.Models.Vehicle> inventory;


    public Dealership(String name, String address, String phone, String email, List<org.example.Models.Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(org.example.Models.Vehicle vehicle) {
        inventory.add(vehicle);
        // adding this note to remind myself to add all the codes

    }

    public List<org.example.Models.Vehicle> getInventory() {
        return inventory;
    }
    public void removeVehicle(org.example.Models.Vehicle vehicle) {
        inventory.remove(vehicle);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInventory(List<org.example.Models.Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<org.example.Models.Vehicle> searchByPrice(double price) {
        return null;
    }
        public List<org.example.Models.Vehicle> searchByOdometer(int odometer) {
        return null;

    }
    public List<org.example.Models.Vehicle> searchByMake(String make) {
        return null;
    }
    public List<org.example.Models.Vehicle> searchByModel(String model) {
        return null;

    }
    public List<org.example.Models.Vehicle> searchByType(String type) {
        return null;
    }
    public List<org.example.Models.Vehicle> searchByColor(String color) {
        return null;
    }
    public List<org.example.Models.Vehicle> searchByVin(int vin) {
        return null;
    }
    public List<org.example.Models.Vehicle> searchByYear(int year) {
        return null;
    }
    public List<org.example.Models.Vehicle> searchByAll(String search) {
        return null;
    }


}
