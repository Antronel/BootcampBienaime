package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // File setup
        String fileName = "transactions.csv";
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Create file if it doesn't exist
            } catch (IOException e) {
                System.out.println("Error creating file.");
                e.printStackTrace();
                return; // Exit the program if file cannot be created
            }
        }

        while (running) {
            // Home Screen
            System.out.println("\n--- Home Screen ---");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
            String option = sc.nextLine().toUpperCase();

            switch (option) {
                case "D":
                case "P":
                    // Input validation for date
                    String date = getValidDate(sc);

                    System.out.println("Time");
                    String time = sc.nextLine();
                    System.out.println("Description");
                    String description = sc.nextLine();
                    System.out.println("Vendor");
                    String vendor = sc.nextLine();
                    System.out.println("Amount");

                    // Input validation for amount
                    double amount = getValidAmount(sc);

                    if (option.equals("P")) {
                        amount = -amount; // Make payment a negative value
                    }

                    String entry = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
                    System.out.println(entry);

                    // Writing the transaction to the file
                    try (FileWriter writer = new FileWriter(fileName, true)) {
                        writer.write(entry + "\n");
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing to the file.");
                        e.printStackTrace();
                    }
                    break;

                case "L":
                    boolean inLedger = true;
                    while (inLedger) {
                        System.out.println("\n--- Ledger Menu ---");
                        System.out.println("A) All");
                        System.out.println("D) Deposits");
                        System.out.println("P) Payments");
                        System.out.println("R) Reports");
                        System.out.println("H) Home");
                        System.out.print("Choose an option: ");
                        String ledgerChoice = sc.nextLine().toUpperCase();

                        switch (ledgerChoice) {
                            case "A":
                                System.out.println("\n--- All Transactions ---");
                                try {
                                    List<String> allLines = Files.readAllLines(Paths.get(fileName));
                                    for (String line : allLines) {
                                        System.out.println(line);
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error reading transactions.");
                                    e.printStackTrace();
                                }
                                break;

                            case "D":
                                System.out.println("\n--- Deposits Only ---");
                                try {
                                    List<String> depositLines = Files.readAllLines(Paths.get(fileName));
                                    for (String line : depositLines) {
                                        String[] parts = line.split("\\|");
                                        if (parts.length == 5 && !parts[4].startsWith("-")) {
                                            System.out.println(line);
                                        }
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error reading transactions.");
                                    e.printStackTrace();
                                }
                                break;

                            case "P":
                                System.out.println("\n--- Payments Only ---");
                                try {
                                    List<String> paymentLines = Files.readAllLines(Paths.get(fileName));
                                    for (String line : paymentLines) {
                                        String[] parts = line.split("\\|");
                                        if (parts.length == 5 && parts[4].startsWith("-")) { // Check for negative amount
                                            System.out.println(line);
                                        }
                                    }
                                } catch (IOException e) {
                                    System.out.println("Error reading transactions.");
                                    e.printStackTrace();
                                }
                                break;

                            case "R":
                                System.out.println("\n--- Reports ---");
                                System.out.println("1) Month To Date");
                                String reportChoice = sc.nextLine();
                                switch (reportChoice) {
                                    case "1":
                                        System.out.println("\n--- Month To Date ---");

                                        // Get current date (month & year)
                                        LocalDate today = LocalDate.now();
                                        int currentMonth = today.getMonthValue();
                                        int currentYear = today.getYear();

                                        try {
                                            List<String> lines = Files.readAllLines(Paths.get(fileName));
                                            for (String line : lines) {
                                                String[] parts = line.split("\\|");
                                                if (parts.length == 5) {
                                                    String dateStr = parts[0]; // The date is in the first column (date|time|...)
                                                    try {
                                                        LocalDate transactionDate = LocalDate.parse(dateStr); // Parse the date string into LocalDate

                                                        // Check if the transaction is from the current month and year
                                                        if (transactionDate.getMonthValue() == currentMonth && transactionDate.getYear() == currentYear) {
                                                            System.out.println(line); // Print the transaction
                                                        }
                                                    } catch (DateTimeParseException e) {
                                                        System.out.println("Skipping invalid date format in transaction: " + dateStr);
                                                    }
                                                }
                                            }
                                        } catch (IOException e) {
                                            System.out.println("Error reading transactions.");
                                            e.printStackTrace();
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                }
                                break;

                            case "H":
                                inLedger = false;
                                break;

                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case "X":
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to validate date input
    private static String getValidDate(Scanner sc) {
        String date = "";
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter the date (YYYY-MM-DD): ");
            date = sc.nextLine();
            try {
                LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE); // Try parsing the date
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            }
        }
        return date;
    }

    // Helper method to validate amount input
    private static double getValidAmount(Scanner sc) {
        double amount = 0.0;
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.println("Enter the amount: ");
                amount = Double.parseDouble(sc.nextLine()); // Try parsing the amount
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }
        return amount;
    }
}
