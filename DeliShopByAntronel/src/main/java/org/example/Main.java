package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Order currentOrder = new Order();

    public static void main(String[] args) {
        System.out.println("Welcome to DELI-cious!");
        boolean running = true;

        while (running) {
            System.out.println("\nHOME MENU");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    currentOrder = new Order();
                    orderMenu();
                }
                case "0" -> {
                    System.out.println("Thanks for visiting DELI-cious!");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void orderMenu() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nORDER MENU");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> {
                    checkout();
                    ordering = false;
                }
                case "0" -> {
                    currentOrder.clearOrder();
                    System.out.println("Order cancelled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSandwich() {
        System.out.println("\n=== ADD SANDWICH ===");

        System.out.print("Select bread (white/wheat/rye/wrap): ");
        String bread = scanner.nextLine().toLowerCase();

        System.out.print("Select size (4/8/12): ");
        int size = Integer.parseInt(scanner.nextLine());

        List<String> meats = new ArrayList<>();
        System.out.println("\n=== PREMIUM TOPPINGS ===");
        System.out.println("Select meats (enter 0 when done):");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("0) Done selecting meats");
        String[] meatArray = scanner.nextLine().split(",");
        for (String meat : meatArray) {
            if (!meat.trim().isEmpty()) meats.add(meat.trim());
        }

        List<String> cheeses = new ArrayList<>();
        System.out.println("\nSelect cheese (enter 0 when done):");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.println("0) Done selecting cheese");
        String[] cheeseArray = scanner.nextLine().split(",");
        for (String cheese : cheeseArray) {
            if (!cheese.trim().isEmpty()) cheeses.add(cheese.trim());
        }

        List<String> toppings = new ArrayList<>();
        System.out.println("Select toppings (enter 0 when done):");
        System.out.println("1) Lettuce");
        System.out.println("2) Peppers");
        System.out.println("3) Onions");
        System.out.println("4) Tomatoes");
        System.out.println("5) Jalapeños");
        System.out.println("6) Cucumbers");
        System.out.println("7) Pickles");
        System.out.println("8) Guacamole");
        System.out.println("9) Mushrooms");
        System.out.println("0) Done selecting toppings");
        String[] toppingArray = scanner.nextLine().split(",");
        for (String topping : toppingArray) {
            if (!topping.trim().isEmpty()) toppings.add(topping.trim());
        }

        List<String> sauces = new ArrayList<>();
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands");
        System.out.println("6) Vinaigrette");
        System.out.println("0) Done selecting sauces");
        String[] sauceArray = scanner.nextLine().split(",");
        for (String sauce : sauceArray) {
            if (!sauce.trim().isEmpty()) sauces.add(sauce.trim());
        }

        System.out.print("Would you like it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, meats, cheeses, toppings, sauces, toasted);
    }

    private static void addDrink() {
        System.out.println("\n=== ADD DRINK ===");
        System.out.print("Enter drink size (small/medium/large): ");
        String size = scanner.nextLine().toLowerCase();
        System.out.println("\nSelect drink flavor:");
        System.out.println("1) Coca-Cola");
        System.out.println("2) Pepsi");
        System.out.println("3) Sprite");
        System.out.println("4) Orange Soda");
        System.out.println("5) Root Beer");
        System.out.println("6) Dr Pepper");
        System.out.println("7) Lemonade");
        System.out.println("8) Iced Tea");
        System.out.println("9) Water");
        System.out.println("10) Coffee");
        System.out.print("Enter your choice (1-10): ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
        System.out.println("Drink added to order.");
    }

    private static void addChips() {
        System.out.println("\n=== ADD CHIPS ===");
        // Select chip type
        System.out.println("\nSelect chip type:");
        System.out.println("1) Classic Lay's");
        System.out.println("2) BBQ Lay's");
        System.out.println("3) Sour Cream & Onion");
        System.out.println("4) Cheddar & Sour Cream");
        System.out.println("5) Salt & Vinegar");
        System.out.println("6) Flamin' Hot Cheetos");
        System.out.println("7) Doritos Nacho Cheese");
        System.out.println("8) Doritos Cool Ranch");
        System.out.println("9) Fritos Corn Chips");
        System.out.println("10) Pringles Original");
        System.out.println("11) Kettle Cooked Sea Salt");
        System.out.println("12) Baked Lay's");
        System.out.print("Enter your choice (1-12): ");
        String flavor = scanner.nextLine();

        Chips chips = new Chips(flavor);
        currentOrder.addChips(chips);

        System.out.println("Chips added to order.");
    }

    private static void checkout() {
        System.out.println("\n=== CHECKOUT ===");
        System.out.println(currentOrder.getOrderSummary());

        System.out.print("Confirm order? (yes to confirm / anything else to cancel): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            try {
                currentOrder.saveReceipt();
                System.out.println("Receipt saved. You will receive an email shorlty. Thank you for your order!");
            } catch (Exception e) {
                System.out.println("Failed to save receipt: " + e.getMessage());
            }
        } else {
            currentOrder.clearOrder();
            System.out.println("Order canceled.");
        }
    }

    private static class Sandwich {
        public Sandwich(String bread, int size, List<String> meats, List<String> cheeses, List<String> toppings, List<String> sauces, boolean toasted) {
        }
    }
}
