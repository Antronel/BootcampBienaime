package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private int size;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String bread, int size, List<String> meats, List<String> cheeses,
                    List<String> toppings, List<String> sauces, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.meats = meats != null ? meats : new ArrayList<>();
        this.cheeses = cheeses != null ? cheeses : new ArrayList<>();
        this.toppings = toppings != null ? toppings : new ArrayList<>();
        this.sauces = sauces != null ? sauces : new ArrayList<>();
        this.toasted = toasted;
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(bread).append(" sandwich\n");
        if (toasted) sb.append("Toasted\n");
        if (!meats.isEmpty()) sb.append("Meats: ").append(String.join(", ", meats)).append("\n");
        if (!cheeses.isEmpty()) sb.append("Cheeses: ").append(String.join(", ", cheeses)).append("\n");
        if (!toppings.isEmpty()) sb.append("Toppings: ").append(String.join(", ", toppings)).append("\n");
        if (!sauces.isEmpty()) sb.append("Sauces: ").append(String.join(", ", sauces)).append("\n");
        sb.append(String.format("Price: $%.2f\n", calculatePrice()));
        return sb.toString();
    }

    public double calculatePrice() {
        double basePrice = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0.0;
        };
        double meatPrice = switch (size) {
            case 4 -> meats.size() * 1.00;
            case 8 -> meats.size() * 2.00;
            case 12 -> meats.size() * 3.00;
            default -> 0.0;
        };
        double cheesePrice = switch (size) {
            case 4 -> cheeses.size() * 0.75;
            case 8 -> cheeses.size() * 1.50;
            case 12 -> cheeses.size() * 2.25;
            default -> 0.0;
        };
        return basePrice + meatPrice + cheesePrice;
    }
}