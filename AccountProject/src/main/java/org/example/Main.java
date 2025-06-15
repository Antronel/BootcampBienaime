package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Home Screen ---");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Select an option: ");
            String option = sc.nextLine().toUpperCase();

            switch (option) {
                case "D":
                case "P":
                    handleTransaction(option, sc);
                    break;
                case "L":
                    showLedger(sc);
                    break;
                case "X":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void handleTransaction(String type, Scanner sc) {
        System.out.println("Date (yyyy-MM-dd):");
        String date = sc.nextLine();
        System.out.println("Time (HH:mm:ss):");
        String time = sc.nextLine();
        System.out.println("Description:");
        String description = sc.nextLine();
        System.out.println("Vendor:");
        String vendor = sc.nextLine();
        System.out.println("Amount:");
        String amount = sc.nextLine();

        if (type.equals("P")) {
            amount = "-" + amount;
        }

        String entry = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

        try (FileWriter writer = new FileWriter("transactions.csv", true)) {
            writer.write(entry + "\n");
            System.out.println("Transaction saved.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void showLedger(Scanner sc) {
        boolean inLedger = true;

        while (inLedger) {
            System.out.println("\n--- Ledger ---");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Select an option: ");
            String option = sc.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    displayEntries("ALL");
                    break;
                case "D":
                    displayEntries("DEPOSIT");
                    break;
                case "P":
                    displayEntries("PAYMENT");
                    break;
                case "R":
                    showReports(sc);
                    break;
                case "H":
                    inLedger = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void displayEntries(String filter) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("transactions.csv"));
            Collections.reverse(lines);
            for (String line : lines) {
                String[] parts = line.split("\\|");
                double amt = Double.parseDouble(parts[4]);
                switch (filter) {
                    case "ALL":
                        System.out.println(line);
                        break;
                    case "DEPOSIT":
                        if (amt > 0) System.out.println(line);
                        break;
                    case "PAYMENT":
                        if (amt < 0) System.out.println(line);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void showReports(Scanner sc) {
        boolean inReports = true;
        while (inReports) {
            System.out.println("\n--- Reports ---");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Select an option: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                case "2":
                case "3":
                case "4":
                    System.out.println("Report type not yet implemented.");
                    break;
                case "5":
                    System.out.print("Enter vendor name: ");
                    String vendor = sc.nextLine().toLowerCase();
                    searchByVendor(vendor);
                    break;
                case "0":
                    inReports = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void searchByVendor(String vendorSearch) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("transactions.csv"));
            Collections.reverse(lines);
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts[3].toLowerCase().contains(vendorSearch)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
