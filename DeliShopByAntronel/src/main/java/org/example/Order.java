package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    private LocalDateTime timestamp;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(0, sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(0, drink);
    }

    public void addChips(Chips chip) {
        chips.add(0, chip);
    }

    public double calculateTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.calculatePrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }

    public String getOrderSummary() {
        if (isEmpty()) {
            return "Your order is empty. Please add items before checkout.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===== ORDER SUMMARY =====\n");

        if (!sandwiches.isEmpty()) {
            sb.append("\nSANDWICHES:\n");
            for (Sandwich s : sandwiches) {
                sb.append(s.getDetails()).append("\n");
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("\nDRINKS:\n");
            for (Drink d : drinks) {
                sb.append(d.getDetails()).append("\n");
            }
        }

        if (!chips.isEmpty()) {
            sb.append("\nCHIPS:\n");
            for (Chips c : chips) {
                sb.append(c.getDetails()).append("\n");
            }
        }

        sb.append("\n==========================\n");
        sb.append("TOTAL: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }

    public void saveReceipt() throws IOException {
        String filename = timestamp.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        File dir = new File("receipts");
        if (!dir.exists()) dir.mkdirs();

        File file = new File(dir, filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("DELI-cious Receipt\n");
            writer.write("Order Date: " + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");
            writer.write(getOrderSummary());
            writer.write("\nThank you for your order!");
        }
    }

    public void clearOrder() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
        this.timestamp = LocalDateTime.now();
    }

    public boolean isEmpty() {
        return sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty();
    }
}
