package org.example;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size.toLowerCase();
        this.flavor = flavor;
    }

    public double getPrice() {
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public String getDetails() {
        return size + " " + flavor + " drink - $" + String.format("%.2f", getPrice());
    }
}
