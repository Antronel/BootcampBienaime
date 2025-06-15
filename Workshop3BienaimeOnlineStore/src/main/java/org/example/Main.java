package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> pets = new ArrayList<>();
        pets.add("Dog");
        pets.add("Cat");
        pets.add("Parrot");
        pets.add("Horse");
        pets.add("Sheep");
        pets.add("Rabbit");
        pets.add("Fox");
        pets.add("Turtle");
        pets.add("Lion");
        pets.add("Bear");
        pets.add("Monkey");
        pets.add("Elephant");
        pets.add("Giraffe");

        List<String> cart = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to the Best Pet Store Ever by Antronel!");
            System.out.println("1. View pets");
            System.out.println("2. Add pet to cart");
            System.out.println("3. View cart");
            System.out.println("4. Adopt and Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                System.out.println("Available Pets:");
                for (String pet : pets) {
                    System.out.println("- " + pet);
                }
            }
            else if (option == 2) {
                System.out.println("Enter the name of the pet you want to add:");
                String petName = scanner.nextLine();
                if (pets.contains(petName)) {
                    cart.add(petName);
                    System.out.println(petName + " has been added to your cart!");
                } else {
                    System.out.println("Sorry, we don't have that pet.");
                }
            }
            else if (option == 3) {
                System.out.println("Your Adoption Cart:");
                for (String pet : cart) {
                    System.out.println("- " + pet);
                }
            }
            else if (option == 4) {
                System.out.println("Congratulations! You adopted:");
                for (String pet : cart) {
                    System.out.println("- " + pet);
                }
                break;
            }
            else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
