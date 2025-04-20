package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] inventory = new Book[20];

        // Sample inventory of 20 books
        inventory[0] = new Book(1, "9780439139595", "Harry Potter and the Goblet of Fire");
        inventory[1] = new Book(2, "9780545010221", "Harry Potter and the Deathly Hallows");
        inventory[2] = new Book(3, "9780316769488", "The Catcher in the Rye");
        inventory[3] = new Book(4, "9780061120084", "To Kill a Mockingbird");
        inventory[4] = new Book(5, "9780451524935", "1984");
        inventory[5] = new Book(6, "9780141439600", "Pride and Prejudice");
        inventory[6] = new Book(7, "9780385472579", "Things Fall Apart");
        inventory[7] = new Book(8, "9780743273565", "The Great Gatsby");
        inventory[8] = new Book(9, "9780142437209", "Moby-Dick");
        inventory[9] = new Book(10, "9781503280786", "Frankenstein");
        inventory[10] = new Book(11, "9780060850524", "Brave New World");
        inventory[11] = new Book(12, "9780141321097", "Treasure Island");
        inventory[12] = new Book(13, "9780143105428", "Wuthering Heights");
        inventory[13] = new Book(14, "9780141439556", "Jane Eyre");
        inventory[14] = new Book(15, "9780307277671", "The Road");
        inventory[15] = new Book(16, "9780141182803", "On the Road");
        inventory[16] = new Book(17, "9780316769488", "Slaughterhouse-Five");
        inventory[17] = new Book(18, "9780143039433", "Crime and Punishment");
        inventory[18] = new Book(19, "9780143105985", "The Odyssey");
        inventory[19] = new Book(20, "9780140449266", "The Iliad");

        while (true) {
            System.out.println("\n Welcome to the Neighborhood Library!");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showAvailableBooks(scanner, inventory);
                    break;
                case 2:
                    showCheckedOutBooks(scanner, inventory);
                    break;
                case 3:
                    System.out.println("Goodbye and happy reading!");
                    System.exit(0);
                default:
                    System.out.println("Please choose a valid option (1-3).");
            }
        }
    }

    public static void showAvailableBooks(Scanner scanner, Book[] inventory) {
        System.out.println("\n Available Books:");
        boolean anyAvailable = false;
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book.getId() + ") " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            System.out.println("No books are currently available.");
            return;
        }

        System.out.print("Enter the ID of the book to check out or 0 to return: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (id != 0) {
            for (Book book : inventory) {
                if (book != null && book.getId() == id && !book.isCheckedOut()) {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    book.checkOut(name);
                    System.out.println("Checked out successfully to " + name + "!");
                    return;
                }
            }
            System.out.println("⚠️ Book not found or already checked out.");
        }
    }

    public static void showCheckedOutBooks(Scanner scanner, Book[] inventory) {
        System.out.println("\n Checked Out Books:");
        boolean anyCheckedOut = false;
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println(book);
                anyCheckedOut = true;
            }
        }

        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.print("Enter 'C' to check in a book, or 'X' to return to main menu: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.equals("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (Book book : inventory) {
                if (book != null && book.getId() == id && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book checked in successfully.");
                    return;
                }
            }
            System.out.println("Book not found or not currently checked out.");
        }
    }
}
