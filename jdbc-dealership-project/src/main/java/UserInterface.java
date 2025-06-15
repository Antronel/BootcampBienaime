<<<<<<< HEAD
import com.pluralsight;

import com.pluralsight.DealershipFileManager;
import org.example.Contract;
import org.example.LeaseContract;
import org.example.SalesContract;
import org.example.Models;
import org.example.ContractFileManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private final DealershipFileManager dealershipFileManager;
    private final ContractFileManager contractFileManager;
    private List<Models.Vehicle> inventory;

    public UserInterface(String inventoryFile, String contractsFile) {
        this.scanner = new Scanner(System.in);
        this.dealershipFileManager = newpackage.com.pluralsight.DealershipFileManager(inventoryFile);
        this.contractFileManager = new ContractFileManager(contractsFile);
        this.inventory = dealershipFileManager.loadInventory();
    }

    public UserInterface(Scanner scanner, DealershipFileManager dealershipFileManager, ContractFileManager contractFileManager) {
        this.scanner = scanner;
        this.dealershipFileManager = dealershipFileManager;
        this.contractFileManager = contractFileManager;
    }

    public void display() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processSearchByPriceRequest();
                    break;
                case "2":
                    processSearchByMakeModelRequest();
                    break;
                case "3":
                    processSearchByYearRequest();
                    break;
                case "4":
                    processSearchByColorRequest();
                    break;
                case "5":
                    processSearchByMileage();
                    break;
                case "6":
                    processSearchByType();
                    break;
                case "7":
                    processVehicleSaleOrLease();
                    break;
                case "8":
                    processListAllVehiclesRequest();
                    break;
                case "9":
                    exit = true;
                    System.out.println("Thank you for using the Dealership Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Dealership Management System =====");
        System.out.println("1. Search by Price");
        System.out.println("2. Search by Make/Model");
        System.out.println("3. Search by Year");
        System.out.println("4. Search by Color");
        System.out.println("5. Search by Mileage");
        System.out.println("6. Search by Vehicle Type");
        System.out.println("7. Sell/Lease a Vehicle");
        System.out.println("8. List All Vehicles");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private void processSearchByPriceRequest() {
        System.out.println("\n===== Search by Price =====");
        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByMakeModelRequest() {
        System.out.println("\n===== Search by Make/Model =====");
        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter model (optional, press Enter to skip): ");
        String model = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getMake().toLowerCase().contains(make) &&
                        (model.isEmpty() || vehicle.getModel().toLowerCase().contains(model)))
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByYearRequest() {
        System.out.println("\n===== Search by Year =====");
        System.out.print("Enter minimum year: ");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int maxYear = Integer.parseInt(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByColorRequest() {
        System.out.println("\n===== Search by Color =====");
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getColor().toLowerCase().contains(color))
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByMileage() {
        System.out.println("\n===== Search by Mileage =====");
        System.out.print("Enter maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() <= maxMileage)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByType() {
        System.out.println("\n===== Search by Vehicle Type =====");
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getType().toLowerCase().contains(type))
                .toList();

        displaySearchResults(results);
    }

    private void processVehicleSaleOrLease() {
        System.out.println("\n===== Sell/Lease a Vehicle =====");
        System.out.print("Enter the VIN of the vehicle to sell/lease: ");
        int vin = Integer.parseInt(scanner.nextLine());

        // Find the vehicle in inventory
        Models.Vehicle vehicle = inventory.stream()
                .filter(v -> v.getVin() == vin)
                .findFirst()
                .orElse(null);

        if (vehicle == null) {
            System.out.println("Vehicle not found with VIN: " + vin);
            return;
        }

        // Display vehicle details
        System.out.println("\nSelected Vehicle:");
        System.out.println(vehicle);

        // Collect customer information
        System.out.print("\nEnter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        // Determine if it's a sale or lease
        System.out.print("Is this a Sale or Lease? (S/L): ");
        String contractType = scanner.nextLine().trim().toUpperCase();

        // Get current date
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

        Contract contract;

        if (contractType.equals("L")) {
            // Check if vehicle is eligible for lease (no more than 3 years old)
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (currentYear - vehicle.getYear() > 3) {
                System.out.println("Error: Cannot lease a vehicle over 3 years old.");
                return;
            }

            // Create lease contract
            contract = new LeaseContract(date, customerName, customerEmail, vehicle);
        } else {
            // Ask if financing is needed for sales
            System.out.print("Would you like to finance this purchase? (Y/N): ");
            boolean isFinanced = scanner.nextLine().trim().toUpperCase().equals("Y");

            // Create sales contract
            contract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
        }

        // Display contract details
        System.out.println("\n===== Contract Details =====");
        System.out.println("Date: " + contract.getDate());
        System.out.println("Customer: " + contract.getCustomerName());
        System.out.println("Email: " + contract.getCustomerEmail());
        System.out.println("Vehicle: " + contract.getVehicle().getYear() + " " +
                contract.getVehicle().getMake() + " " + contract.getVehicle().getModel());
        System.out.println("Total Price: $" + String.format("%.2f", contract.getTotalPrice()));

        if (contract.getMonthlyPayment() > 0) {
            System.out.println("Monthly Payment: $" + String.format("%.2f", contract.getMonthlyPayment()));
        }

        // Confirm transaction
        System.out.print("\nConfirm transaction? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            // Save contract and remove vehicle from inventory
            contractFileManager.saveContract(contract);
            dealershipFileManager.removeVehicle(inventory, vehicle.getVin());

            // Reload inventory
            inventory = dealershipFileManager.loadInventory();

            System.out.println("Transaction completed successfully!");
        } else {
            System.out.println("Transaction cancelled.");
        }
    }

    private void processListAllVehiclesRequest() {
        System.out.println("\n===== All Vehicles =====");
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            for (Models.Vehicle vehicle : inventory) {
                System.out.println(vehicle);
            }
        }
    }

    private void displaySearchResults(List<Models.Vehicle> results) {
        System.out.println("\n===== Search Results =====");
        if (results.isEmpty()) {
            System.out.println("No vehicles found matching your criteria.");
        } else {
            System.out.println("Found " + results.size() + " vehicles:");
            for (Models.Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }
=======
import com.pluralsight;

import com.pluralsight.DealershipFileManager;
import org.example.Contract;
import org.example.LeaseContract;
import org.example.SalesContract;
import org.example.Models;
import org.example.ContractFileManager;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private final DealershipFileManager dealershipFileManager;
    private final ContractFileManager contractFileManager;
    private List<Models.Vehicle> inventory;

    public UserInterface(String inventoryFile, String contractsFile) {
        this.scanner = new Scanner(System.in);
        this.dealershipFileManager = newpackage.com.pluralsight.DealershipFileManager(inventoryFile);
        this.contractFileManager = new ContractFileManager(contractsFile);
        this.inventory = dealershipFileManager.loadInventory();
    }

    public UserInterface(Scanner scanner, DealershipFileManager dealershipFileManager, ContractFileManager contractFileManager) {
        this.scanner = scanner;
        this.dealershipFileManager = dealershipFileManager;
        this.contractFileManager = contractFileManager;
    }

    public void display() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processSearchByPriceRequest();
                    break;
                case "2":
                    processSearchByMakeModelRequest();
                    break;
                case "3":
                    processSearchByYearRequest();
                    break;
                case "4":
                    processSearchByColorRequest();
                    break;
                case "5":
                    processSearchByMileage();
                    break;
                case "6":
                    processSearchByType();
                    break;
                case "7":
                    processVehicleSaleOrLease();
                    break;
                case "8":
                    processListAllVehiclesRequest();
                    break;
                case "9":
                    exit = true;
                    System.out.println("Thank you for using the Dealership Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Dealership Management System =====");
        System.out.println("1. Search by Price");
        System.out.println("2. Search by Make/Model");
        System.out.println("3. Search by Year");
        System.out.println("4. Search by Color");
        System.out.println("5. Search by Mileage");
        System.out.println("6. Search by Vehicle Type");
        System.out.println("7. Sell/Lease a Vehicle");
        System.out.println("8. List All Vehicles");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private void processSearchByPriceRequest() {
        System.out.println("\n===== Search by Price =====");
        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByMakeModelRequest() {
        System.out.println("\n===== Search by Make/Model =====");
        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter model (optional, press Enter to skip): ");
        String model = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getMake().toLowerCase().contains(make) &&
                        (model.isEmpty() || vehicle.getModel().toLowerCase().contains(model)))
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByYearRequest() {
        System.out.println("\n===== Search by Year =====");
        System.out.print("Enter minimum year: ");
        int minYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int maxYear = Integer.parseInt(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByColorRequest() {
        System.out.println("\n===== Search by Color =====");
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getColor().toLowerCase().contains(color))
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByMileage() {
        System.out.println("\n===== Search by Mileage =====");
        System.out.print("Enter maximum mileage: ");
        int maxMileage = Integer.parseInt(scanner.nextLine());

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() <= maxMileage)
                .toList();

        displaySearchResults(results);
    }

    private void processSearchByType() {
        System.out.println("\n===== Search by Vehicle Type =====");
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine().trim().toLowerCase();

        List<Models.Vehicle> results = inventory.stream()
                .filter(vehicle -> vehicle.getType().toLowerCase().contains(type))
                .toList();

        displaySearchResults(results);
    }

    private void processVehicleSaleOrLease() {
        System.out.println("\n===== Sell/Lease a Vehicle =====");
        System.out.print("Enter the VIN of the vehicle to sell/lease: ");
        int vin = Integer.parseInt(scanner.nextLine());

        // Find the vehicle in inventory
        Models.Vehicle vehicle = inventory.stream()
                .filter(v -> v.getVin() == vin)
                .findFirst()
                .orElse(null);

        if (vehicle == null) {
            System.out.println("Vehicle not found with VIN: " + vin);
            return;
        }

        // Display vehicle details
        System.out.println("\nSelected Vehicle:");
        System.out.println(vehicle);

        // Collect customer information
        System.out.print("\nEnter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        // Determine if it's a sale or lease
        System.out.print("Is this a Sale or Lease? (S/L): ");
        String contractType = scanner.nextLine().trim().toUpperCase();

        // Get current date
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

        Contract contract;

        if (contractType.equals("L")) {
            // Check if vehicle is eligible for lease (no more than 3 years old)
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (currentYear - vehicle.getYear() > 3) {
                System.out.println("Error: Cannot lease a vehicle over 3 years old.");
                return;
            }

            // Create lease contract
            contract = new LeaseContract(date, customerName, customerEmail, vehicle);
        } else {
            // Ask if financing is needed for sales
            System.out.print("Would you like to finance this purchase? (Y/N): ");
            boolean isFinanced = scanner.nextLine().trim().toUpperCase().equals("Y");

            // Create sales contract
            contract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
        }

        // Display contract details
        System.out.println("\n===== Contract Details =====");
        System.out.println("Date: " + contract.getDate());
        System.out.println("Customer: " + contract.getCustomerName());
        System.out.println("Email: " + contract.getCustomerEmail());
        System.out.println("Vehicle: " + contract.getVehicle().getYear() + " " +
                contract.getVehicle().getMake() + " " + contract.getVehicle().getModel());
        System.out.println("Total Price: $" + String.format("%.2f", contract.getTotalPrice()));

        if (contract.getMonthlyPayment() > 0) {
            System.out.println("Monthly Payment: $" + String.format("%.2f", contract.getMonthlyPayment()));
        }

        // Confirm transaction
        System.out.print("\nConfirm transaction? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            // Save contract and remove vehicle from inventory
            contractFileManager.saveContract(contract);
            dealershipFileManager.removeVehicle(inventory, vehicle.getVin());

            // Reload inventory
            inventory = dealershipFileManager.loadInventory();

            System.out.println("Transaction completed successfully!");
        } else {
            System.out.println("Transaction cancelled.");
        }
    }

    private void processListAllVehiclesRequest() {
        System.out.println("\n===== All Vehicles =====");
        if (inventory.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            for (Models.Vehicle vehicle : inventory) {
                System.out.println(vehicle);
            }
        }
    }

    private void displaySearchResults(List<Models.Vehicle> results) {
        System.out.println("\n===== Search Results =====");
        if (results.isEmpty()) {
            System.out.println("No vehicles found matching your criteria.");
        } else {
            System.out.println("Found " + results.size() + " vehicles:");
            for (Models.Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }
>>>>>>> b4c7cd8 (Add jdbc-dealership-project files)
}