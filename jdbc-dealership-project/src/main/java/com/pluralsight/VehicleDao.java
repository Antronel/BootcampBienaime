package com.pluralsight;

import org.example.Models;

import java.util.List;

public class VehicleDao {
    List<org.example.Vehicle> getVehiclesByPriceRange(double min, double max);
    List<org.example.Vehicle> getVehiclesByMakeModel(String make, String model);
    List<org.example.Vehicle> getVehiclesByYearRange(int minYear, int maxYear);
    List<org.example.Vehicle> getVehiclesByColor(String color);
    List<org.example.Vehicle> getVehiclesByMileageRange(int min, int max);
    List<Models.Vehicle> getVehiclesByType(String type);

    void addVehicle(Models.Vehicle vehicle);
    void removeVehicleByVin(String vin);

}
