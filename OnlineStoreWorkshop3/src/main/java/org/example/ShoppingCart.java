package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public double get;
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        this.products.add(product);
    }

    public void removeProduct(String sku) {
        Product toRemove = null;
        for (Product product : this.products) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                toRemove = product;
                break;
            }
        }
        if (toRemove != null) {
            this.products.remove(toRemove);
            System.out.println("Your item has been removed.");
        } else {
            System.out.println("That SKU doesn't exist.");
        }
    }

    public double getCartTotal() {
        double total = 0.0;
        for (Product product : this.products) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProductsInList() {
        return products;
    }
}
