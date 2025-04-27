package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = FileLoader.readFile();

        while (true) {
            out.println("Welcome to The Exotic Pet Store");
            out.println("Choose your option:");
            out.println("1. View all products");
            out.println("2. Search by SKU");
            out.println("3. Search by price range");
            out.println("4. Search by name");
            out.println("5. Remove from cart");
            out.println("6. View cart");
            out.println("7. Checkout");
            out.println("8. Exit");

            int userOption = Integer.parseInt(scanner.nextLine());

            switch (userOption) {
                case 1:
                    displayAllProducts(products);
                    break;
                case 2:
                    out.println("Please enter the SKU of the product you're looking for:");
                    String sku = scanner.nextLine();
                    Product foundProduct = searchSku(products, sku);
                    if (foundProduct != null) {
                        shoppingCart.addProductToCart(foundProduct);
                        out.println("Your item has been added to the cart.");
                    } else {
                        out.println("Product not found!");
                    }
                    break;
                case 3:
                    out.println("What is your minimum budget?");
                    double min = Double.parseDouble(scanner.nextLine());
                    out.println("What is your maximum budget?");
                    double max = Double.parseDouble(scanner.nextLine());
                    List<Product> range = searchByPriceRange(products, min, max);
                    displayAllProducts(range);
                    break;
                case 4:
                    out.println("Please enter the name of the product you're looking for:");
                    String name = scanner.nextLine();
                    List<Product> results = searchProduct(products, name);
                    displayAllProducts(results);
                    break;
                case 5:
                    out.println("To remove a product, enter its SKU:");
                    String returnSku = scanner.nextLine();
                    shoppingCart.removeProduct(returnSku);
                    break;
                case 6:
                    displayAllProducts(shoppingCart.getProductsInList());
                    break;
                case 7:
                    checkOut(shoppingCart, scanner);
                    break;
                case 8:
                    exit(0);
                    break;
                default:
                    out.println("Invalid option. Try again!");
            }
        }
    }

    public static void displayAllProducts(List<Product> products) {
        for (Product inventory : products) {
            out.println(inventory.productName() + " | " + inventory.sku() + " | " + inventory.department() + " | $" + inventory.price());
        }
    }

    public static List<Product> searchProduct(List<Product> products, String name) {
        List<Product> foundProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.productName().toLowerCase().contains(name.toLowerCase())) {
                foundProduct.add(product);
            }
        }
        return foundProduct;
    }

    public static Product searchSku(List<Product> products, String sku) {
        for (Product product : products) {
            if (product.sku().equalsIgnoreCase(sku)) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> searchByPriceRange(List<Product> products, double min, double max) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.price() >= min && product.price() <= max) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public static void checkOut(ShoppingCart cart, Scanner scanner) {
        out.println("Your total is: $" + String.format("%.2f", cart.getCartTotal()) + ". Please pay now!");
        double userBalance = Double.parseDouble(scanner.nextLine());

        while (userBalance < cart.getCartTotal()) {
            out.println("Insufficient payment. You still owe $" + String.format("%.2f", cart.getCartTotal() - userBalance));
            out.print("Please enter more money: ");
            userBalance += Double.parseDouble(scanner.nextLine());
        }

        if (userBalance == cart.getCartTotal()) {
            out.println("Payment accepted. Thank you for shopping with us!");
        } else {
            double change = userBalance - cart.getCartTotal();
            out.println("Payment complete. Your change is: $" + String.format("%.2f", change));
        }
    }
}

