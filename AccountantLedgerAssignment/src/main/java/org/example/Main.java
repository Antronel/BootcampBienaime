package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static final String FILE_NAME = "transactions.csv";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showHomeScreen();
            String input = sc.nextLine().toUpperCase();

            switch (input) {
                case "D":
                case "P":
                    handleTransaction(input.equals("D"));
                    break;
                case "L":
                    showLedgerScreen();
                    break;
                case "X":
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showHomeScreen() {
        System.out.println("\n--- Home Screen ---");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleTransaction(boolean isDeposit) {
        System.out.println("Date (YYYY-MM-DD):");
        String date = sc.nextLine();
        System.out.println("Time (HH:MM:SS):");
        String time = sc.nextLine();
        System.out.println("Description:");
        String description = sc.nextLine();
        System.out.println("Vendor:");
        String vendor = sc.nextLine();
        System.out.println("Amount:");
        String amount = sc.nextLine();

        if (!isDeposit && !amount.startsWith("-")) {
            amount = "-" + amount;
        }

        String entry = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
        appendTransaction(entry);
        System.out.println("Transaction saved.");
    }

    private static void appendTransaction(String entry) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(entry + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    private static void showLedgerScreen() {
        while (true) {
            System.out.println("\n--- Ledger ---");
            System.out.println("A) All Entries");
            System.out.println("D) Deposits Only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().toUpperCase();

            List<String> transactions = readTransactions();
            if (transactions == null) return;

            switch (choice) {
                case "A":
                    printTransactions(transactions);
                    break;
                case "D":
                    printFiltered(transactions, false);
                    break;
                case "P":
                    printFiltered(transactions, true);
                    break;
                case "R":
                    showReportsMenu(transactions);
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static List<String> readTransactions() {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
            Collections.reverse(entries);
            return entries;
        } catch (IOException e) {
            System.out.println("Error reading transactions.");
            return null;
        }
    }

    private static void printTransactions(List<String> transactions) {
        System.out.println("\n--- All Transactions ---");
        transactions.forEach(System.out::println);
    }

    private static void printFiltered(List<String> transactions, boolean paymentsOnly) {
        System.out.println("\n--- Filtered Transactions ---");
        for (String t : transactions) {
            String[] parts = t.split("\\|");
            if (parts.length >= 5) {
                double amt = Double.parseDouble(parts[4]);
                if ((paymentsOnly && amt < 0) || (!paymentsOnly && amt >= 0)) {
                    System.out.println(t);
                }
            }
        }
    }

    private static void showReportsMenu(List<String> transactions) {
        while (true) {
            System.out.println("\n--- Reports ---");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    filterByDate(transactions, "monthToDate");
                    break;
                case "2":
                    filterByDate(transactions, "lastMonth");
                    break;
                case "3":
                    filterByDate(transactions, "yearToDate");
                    break;
                case "4":
                    filterByDate(transactions, "lastYear");
                    break;
                case "5":
                    System.out.print("Enter vendor name: ");
                    String vendor = sc.nextLine().toLowerCase();
                    transactions.stream()
                            .filter(t -> t.toLowerCase().contains(vendor))
                            .forEach(System.out::println);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void filterByDate(List<String> transactions, String filterType) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String t : transactions) {
            String[] parts = t.split("\\|");
            if (parts.length >= 1) {
                LocalDate date = LocalDate.parse(parts[0], formatter);
                boolean matches = switch (filterType) {
                    case "monthToDate" -> date.getMonth().equals(today.getMonth()) && date.getYear() == today.getYear();
                    case "lastMonth" -> date.getMonthValue() == today.minusMonths(1).getMonthValue() &&
                            date.getYear() == today.minusMonths(1).getYear();
                    case "yearToDate" -> date.getYear() == today.getYear();
                    case "lastYear" -> date.getYear() == today.getYear() - 1;
                    default -> false;
                };
                if (matches) {
                    System.out.println(t);
                }
            }
        }
    }
}
