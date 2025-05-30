package org.example;

public class Chips {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getDetails() {
        return flavor + " chips - $" + String.format("%.2f", getPrice());
    }
}
