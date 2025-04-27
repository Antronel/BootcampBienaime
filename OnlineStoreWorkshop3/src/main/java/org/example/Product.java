package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public record Product(String sku, String productName, double price, String department) {

    public Product(String sku, String productName, double price, String department) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or empty.");
        }
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        this.sku = sku.trim();
        this.productName = productName.trim();
        this.price = price;
        this.department = department.trim();
    }

    @Override
    public String toString() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format("SKU: %s, Name: %s, Department: %s, Price: %s",
                Objects.toString(sku, "N/A"),
                Objects.toString(productName, "N/A"),
                Objects.toString(department, "N/A"),
                currencyFormatter.format(price));
    }

    // Private helper methods

}