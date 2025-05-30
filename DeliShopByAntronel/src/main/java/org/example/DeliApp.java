package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder;

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
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> {
                    currentOrder.clearOrder();
                    System.out.println("Order cancelled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addSandwich() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== BUILD YOUR SANDWICH ===");

        // Select bread type
        System.out.println("\nSelect your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Enter your choice (1-4): ");

        String breadType = "";
        int breadChoice = scanner.nextInt();
        switch (breadChoice) {
            case 1:
                breadType = "White";
                break;
            case 2:
                breadType = "Wheat";
                break;
            case 3:
                breadType = "Rye";
                break;
            case 4:
                breadType = "Wrap";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to White bread.");
                breadType = "White";
        }

        // Select sandwich size
        System.out.println("\nSandwich size:");
        System.out.println("1) 4\" - $5.50");
        System.out.println("2) 8\" - $7.00");
        System.out.println("3) 12\" - $8.50");
        System.out.print("Enter your choice (1-3): ");

        String size = "";
        double basePrice = 0.0;
        int sizeChoice = scanner.nextInt();
        switch (sizeChoice) {
            case 1:
                size = "4\"";
                basePrice = 5.50;
                break;
            case 2:
                size = "8\"";
                basePrice = 7.00;
                break;
            case 3:
                size = "12\"";
                basePrice = 8.50;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 4\" sandwich.");
                size = "4\"";
                basePrice = 5.50;
        }

        // Initialize sandwich object (you'll need to create this class)
        // Sandwich sandwich = new Sandwich(breadType, size, basePrice);
        double totalPrice = basePrice;
        List<String> toppings = new ArrayList<>();

        // Add meats
        System.out.println("\n=== PREMIUM TOPPINGS ===");
        System.out.println("Select meats (enter 0 when done):");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("0) Done selecting meats");

        double meatPrice = (size.equals("4\"")) ? 1.00 : (size.equals("8\"")) ? 2.00 : 3.00;
        double extraMeatPrice = (size.equals("4\"")) ? 0.50 : (size.equals("8\"")) ? 1.00 : 1.50;

        while (true) {
            System.out.print("Enter choice: ");
            int meatChoice = scanner.nextInt();
            if (meatChoice == 0) break;

            String meat = "";
            switch (meatChoice) {
                case 1:
                    meat = "Steak";
                    break;
                case 2:
                    meat = "Ham";
                    break;
                case 3:
                    meat = "Salami";
                    break;
                case 4:
                    meat = "Roast Beef";
                    break;
                case 5:
                    meat = "Chicken";
                    break;
                case 6:
                    meat = "Bacon";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            // Check if meat already added
            boolean alreadyHas = toppings.contains(meat);
            if (alreadyHas) {
                System.out.print("You already have " + meat + ". Add extra? (y/n): ");
                String extraChoice = scanner.next();
                if (extraChoice.equalsIgnoreCase("y")) {
                    toppings.add("Extra " + meat);
                    totalPrice += extraMeatPrice;
                    System.out.println("Added extra " + meat + " (+$" + String.format("%.2f", extraMeatPrice) + ")");
                }
            } else {
                toppings.add(meat);
                totalPrice += meatPrice;
                System.out.println("Added " + meat + " (+$" + String.format("%.2f", meatPrice) + ")");
            }
        }

        // Add cheese
        System.out.println("\nSelect cheese (enter 0 when done):");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.println("0) Done selecting cheese");

        double cheesePrice = (size.equals("4\"")) ? 0.75 : (size.equals("8\"")) ? 1.50 : 2.25;
        double extraCheesePrice = (size.equals("4\"")) ? 0.30 : (size.equals("8\"")) ? 0.60 : 0.90;

        while (true) {
            System.out.print("Enter choice: ");
            int cheeseChoice = scanner.nextInt();
            if (cheeseChoice == 0) break;

            String cheese = "";
            switch (cheeseChoice) {
                case 1:
                    cheese = "American";
                    break;
                case 2:
                    cheese = "Provolone";
                    break;
                case 3:
                    cheese = "Cheddar";
                    break;
                case 4:
                    cheese = "Swiss";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            // Check if cheese already added
            boolean alreadyHas = toppings.contains(cheese);
            if (alreadyHas) {
                System.out.print("You already have " + cheese + ". Add extra? (y/n): ");
                String extraChoice = scanner.next();
                if (extraChoice.equalsIgnoreCase("y")) {
                    toppings.add("Extra " + cheese);
                    totalPrice += extraCheesePrice;
                    System.out.println("Added extra " + cheese + " (+$" + String.format("%.2f", extraCheesePrice) + ")");
                }
            } else {
                toppings.add(cheese);
                totalPrice += cheesePrice;
                System.out.println("Added " + cheese + " (+$" + String.format("%.2f", cheesePrice) + ")");
            }
        }

        // Add regular toppings
        System.out.println("\n=== REGULAR TOPPINGS (FREE) ===");
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

        while (true) {
            System.out.print("Enter choice: ");
            int toppingChoice = scanner.nextInt();
            if (toppingChoice == 0) break;

            String topping = "";
            switch (toppingChoice) {
                case 1:
                    topping = "Lettuce";
                    break;
                case 2:
                    topping = "Peppers";
                    break;
                case 3:
                    topping = "Onions";
                    break;
                case 4:
                    topping = "Tomatoes";
                    break;
                case 5:
                    topping = "Jalapeños";
                    break;
                case 6:
                    topping = "Cucumbers";
                    break;
                case 7:
                    topping = "Pickles";
                    break;
                case 8:
                    topping = "Guacamole";
                    break;
                case 9:
                    topping = "Mushrooms";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (!toppings.contains(topping)) {
                toppings.add(topping);
                System.out.println("Added " + topping + " (FREE)");
            } else {
                System.out.println("You already have " + topping + " on your sandwich.");
            }
        }

        // Add sauces
        System.out.println("\n=== SAUCES (FREE) ===");
        System.out.println("Select sauces (enter 0 when done):");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands");
        System.out.println("6) Vinaigrette");
        System.out.println("0) Done selecting sauces");

        while (true) {
            System.out.print("Enter choice: ");
            int sauceChoice = scanner.nextInt();
            if (sauceChoice == 0) break;

            String sauce = "";
            switch (sauceChoice) {
                case 1:
                    sauce = "Mayo";
                    break;
                case 2:
                    sauce = "Mustard";
                    break;
                case 3:
                    sauce = "Ketchup";
                    break;
                case 4:
                    sauce = "Ranch";
                    break;
                case 5:
                    sauce = "Thousand Islands";
                    break;
                case 6:
                    sauce = "Vinaigrette";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (!toppings.contains(sauce)) {
                toppings.add(sauce);
                System.out.println("Added " + sauce + " (FREE)");
            } else {
                System.out.println("You already have " + sauce + " on your sandwich.");
            }
        }

        // Add sides
        System.out.println("\n=== SIDES (FREE) ===");
        System.out.println("Select sides (enter 0 when done):");
        System.out.println("1) Au Jus");
        System.out.println("2) Sauce");
        System.out.println("0) Done selecting sides");

        while (true) {
            System.out.print("Enter choice: ");
            int sideChoice = scanner.nextInt();
            if (sideChoice == 0) break;

            String side = "";
            switch (sideChoice) {
                case 1:
                    side = "Au Jus";
                    break;
                case 2:
                    side = "Sauce";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (!toppings.contains(side)) {
                toppings.add(side);
                System.out.println("Added " + side + " (FREE)");
            } else {
                System.out.println("You already have " + side + " with your sandwich.");
            }
        }

        // Toasted option
        System.out.print("\nWould you like the sandwich toasted? (y/n): ");
        String toastChoice = scanner.next();
        boolean isToasted = toastChoice.equalsIgnoreCase("y");

        // Display sandwich summary
        System.out.println("\n=== SANDWICH SUMMARY ===");
        System.out.println("Size: " + size);
        System.out.println("Bread: " + breadType);
        System.out.println("Toppings: " + String.join(", ", toppings));
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
        System.out.println("Price: $" + String.format("%.2f", totalPrice));

        System.out.print("\nAdd this sandwich to your order? (y/n): ");
        String confirmChoice = scanner.next();

        if (confirmChoice.equalsIgnoreCase("y")) {
            // Here you would add the sandwich to the current order
            // currentOrder.addSandwich(sandwich);
            System.out.println("Sandwich added to your order!");
        } else {
            System.out.println("Sandwich not added to order.");
        }
    }

    static void addDrink() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== ADD DRINK ===");

        // Select drink size
        System.out.println("\nSelect drink size:");
        System.out.println("1) Small - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large - $3.00");
        System.out.print("Enter your choice (1-3): ");

        String size = "";
        double price = 0.0;
        int sizeChoice = scanner.nextInt();
        switch (sizeChoice) {
            case 1:
                size = "Small";
                price = 2.00;
                break;
            case 2:
                size = "Medium";
                price = 2.50;
                break;
            case 3:
                size = "Large";
                price = 3.00;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Small drink.");
                size = "Small";
                price = 2.00;
        }

        // Select drink flavor/type
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

        String flavor = "";
        int flavorChoice = scanner.nextInt();
        switch (flavorChoice) {
            case 1:
                flavor = "Coca-Cola";
                break;
            case 2:
                flavor = "Pepsi";
                break;
            case 3:
                flavor = "Sprite";
                break;
            case 4:
                flavor = "Orange Soda";
                break;
            case 5:
                flavor = "Root Beer";
                break;
            case 6:
                flavor = "Dr Pepper";
                break;
            case 7:
                flavor = "Lemonade";
                break;
            case 8:
                flavor = "Iced Tea";
                break;
            case 9:
                flavor = "Water";
                break;
            case 10:
                flavor = "Coffee";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Water.");
                flavor = "Water";
        }

        // Display drink summary
        System.out.println("\n=== DRINK SUMMARY ===");
        System.out.println("Drink: " + size + " " + flavor);
        System.out.println("Price: $" + String.format("%.2f", price));

        System.out.print("\nAdd this drink to your order? (y/n): ");
        String confirmChoice = scanner.next();

        if (confirmChoice.equalsIgnoreCase("y")) {
            // Here you would add the drink to the current order
            // Drink drink = new Drink(size, flavor, price);
            // currentOrder.addDrink(drink);
            System.out.println("Drink added to your order!");
        } else {
            System.out.println("Drink not added to order.");
        }
    }

    static void addChips() {
        Scanner scanner = new Scanner(System.in);

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

        String chipType = "";
        double price = 1.50; // Fixed price from requirements
        int chipChoice = scanner.nextInt();

        switch (chipChoice) {
            case 1:
                chipType = "Classic Lay's";
                break;
            case 2:
                chipType = "BBQ Lay's";
                break;
            case 3:
                chipType = "Sour Cream & Onion";
                break;
            case 4:
                chipType = "Cheddar & Sour Cream";
                break;
            case 5:
                chipType = "Salt & Vinegar";
                break;
            case 6:
                chipType = "Flamin' Hot Cheetos";
                break;
            case 7:
                chipType = "Doritos Nacho Cheese";
                break;
            case 8:
                chipType = "Doritos Cool Ranch";
                break;
            case 9:
                chipType = "Fritos Corn Chips";
                break;
            case 10:
                chipType = "Pringles Original";
                break;
            case 11:
                chipType = "Kettle Cooked Sea Salt";
                break;
            case 12:
                chipType = "Baked Lay's";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Classic Lay's.");
                chipType = "Classic Lay's";
        }

        // Display chips summary
        System.out.println("\n=== CHIPS SUMMARY ===");
        System.out.println("Chips: " + chipType);
        System.out.println("Price: $" + String.format("%.2f", price));

        System.out.print("\nAdd these chips to your order? (y/n): ");
        String confirmChoice = scanner.next();

        if (confirmChoice.equalsIgnoreCase("y")) {
            // Here you would add the chips to the current order
            // Chips chips = new Chips(chipType, price);
            // currentOrder.addChips(chips);
            System.out.println("Chips added to your order!");
        } else {
            System.out.println("Chips not added to order.");
        }
    }

    static void checkout() {
        System.out.println("\n=== CHECKOUT ===");

        // Check if order has items
        if (currentOrder == null || currentOrder.isEmpty()) {
            System.out.println("Your order is empty. Please add items before checkout.");
            return;
        }

        // Display order summary
        String summary = currentOrder.getOrderSummary();
        System.out.println(summary);

        System.out.print("Confirm order? (y = yes, anything else = cancel): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("y")) {
            try {
                currentOrder.saveReceipt();
                System.out.println("Order confirmed and saved to receipt!");
                System.out.println("Thank you for your order!");

                // Clear the order after successful save and return to home screen
                currentOrder.clearOrder();

            } catch (IOException e) {
                System.out.println("Failed to write receipt: " + e.getMessage());
                System.out.println("Order not saved. Please try again.");
            }
        } else {
            System.out.println("Order cancelled.");
            currentOrder.clearOrder();
        }
    }
}
