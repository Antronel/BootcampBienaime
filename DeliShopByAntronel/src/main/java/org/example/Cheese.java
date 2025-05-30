package org.example;

public class Cheese extends Topping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {
        double base = switch (size) {
            case FOUR_INCH -> 0.75;
            case EIGHT_INCH -> 1.50;
            case TWELVE_INCH -> 2.25;
        };
        boolean isExtra = false;
        return base + (isExtra? (switch (size) {
            case FOUR_INCH -> 0.30;
            case EIGHT_INCH -> 0.60;
            case TWELVE_INCH -> 0.90;
        }) : 0.0);
    }
}

