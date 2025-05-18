package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class DealershipFileManager {
    private final String inventoryFile;

    public DealershipFileManager(String inventoryFile) {
        this.inventoryFile = inventoryFile;
    }

    public List<Models.Vehicle> loadInventory() {
        List<Models.Vehicle> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String type = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Models.Vehicle vehicle = new Models.Vehicle(vin, year, make, model, type, color, odometer, price);
                    inventory.add(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }

        return inventory;
    }

    public void saveInventory(List<Models.Vehicle> inventory) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(inventoryFile))) {
            for (Models.Vehicle vehicle : inventory) {
                writer.println(vehicle.toFileString());
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void removeVehicle(List<Models.Vehicle> inventory, int vin) {
        inventory.removeIf(vehicle -> vehicle.getVin() == vin);
        saveInventory(inventory);
    }
}