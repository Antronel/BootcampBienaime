package org.example;

public class Main {
    public static void main(String[] args) {
        Book[] library = new Book[5];

        Book book1 = new Book(305, "954", "HarryPotter", true, "Ava");
        library[0] = book1;

        Book book2 = new Book(235, "455", "HarryPotter2",true, "Marty");
        library[1] = book2;

        Book book3 = new Book(377, "389", "HarryPotter3", false, "Savannah");
        library[2] = book3;

        Book book4 = new Book(299, "666", "HarryPotter4", true, "Marco");
        library[3] = book4;

        Book book5 = new Book(365, "782", "HarryPotter5", true, "Kerby");
        library[4] = book5;

        Book book6 = new Book(261, "001", "HarryPotter6", false, "Mariyah");
        library[5] = book6;
        while (true) {
            // Main menu
            System.out.println("\n🧙 Welcome to the Hogwarts Magical Inventory 🪄");
            System.out.println("What would you like to do?");
            System.out.println("1) List All Magical Items");
            System.out.println("2) Search By Name");
            System.out.println("3) Search By Magic Energy Range");
            System.out.println("4) Search By Magical Color");
            System.out.println("5) Add a Magical Item");
            System.out.println("6) Exit");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    displayMagicalItems(hogwartsInventory);
                    break;
                case 2:
                    searchByName(hogwartsInventory, scanner);
                    break;
                case 3:
                    searchByMagicRange(hogwartsInventory, scanner);
                    break;
                case 4:
                    searchByColor(hogwartsInventory, scanner);
                    break;
                case 5:
                    addMagicalItem(hogwartsInventory, scanner);
                    break;
                case 6:
                    System.out.println("Exiting... May the magic be with you!");
                    System.exit(0);
                default:
                    System.out.println("Please select a valid option (1 through 6)");
            }
        }
    }

    public static void displayMagicalItems(MagicalItem[] inventory) {
        for (MagicalItem item : inventory) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void searchByName(MagicalItem[] inventory, Scanner scanner) {
        System.out.println("Enter the name of the magical item (e.g., Firebolt):");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();

        for (MagicalItem item : inventory) {
            if (item != null && item.getName().equalsIgnoreCase(name)) {
                System.out.println(item);
            }
        }
    }

    public static void searchByMagicRange(MagicalItem[] inventory, Scanner scanner) {
        System.out.println("Enter minimum magic energy:");
        int min = scanner.nextInt();
        System.out.println("Enter maximum magic energy:");
        int max = scanner.nextInt();

        for (MagicalItem item : inventory) {
            if (item != null && item.getMagicEnergy() >= min && item.getMagicEnergy() <= max) {
                System.out.println(item);
            }
        }
    }

    public static void searchByColor(MagicalItem[] inventory, Scanner scanner) {
        System.out.println("Enter the magical item's color:");
        scanner.nextLine(); // consume newline
        String color = scanner.nextLine();

        for (MagicalItem item : inventory) {
            if (item != null && item.getColor().equalsIgnoreCase(color)) {
                System.out.println(item);
            }
        }
    }

    public static void addMagicalItem(MagicalItem[] inventory, Scanner scanner) {
        System.out.println("Enter the name of the magical item:");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();

        System.out.println("Enter the type (e.g., Broomstick, Creature):");
        String type = scanner.nextLine();

        System.out.println("Enter the magical color:");
        String color = scanner.nextLine();

        System.out.println("Enter the magic energy level:");
        int energy = scanner.nextInt();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new MagicalItem(name, type, color, energy);
                System.out.println("✨ Magical item added successfully!");
                break;
            }
        }
    }
}

class MagicalItem {
    private String name;
    private String type;
    private String color;
    private int magicEnergy;

    public MagicalItem(String name, String type, String color, int magicEnergy) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.magicEnergy = magicEnergy;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMagicEnergy() {
        return magicEnergy;
    }

    @Override
    public String toString() {
        return "🪄 " + name + " | Type: " + type + " | Color: " + color + " | Magic Energy: " + magicEnergy;


    }
