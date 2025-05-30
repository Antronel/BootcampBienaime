package org.example;

public class Meat extends Topping {
    private boolean isExtra;

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {
        double base = switch (size) {
            case FOUR_INCH -> 1.00;
            case EIGHT_INCH -> 2.00;
            case TWELVE_INCH -> 3.00;
        };
        return base + (isExtra ? (switch (size) {
            case FOUR_INCH -> 0.50;
            case EIGHT_INCH -> 1.00;
            case TWELVE_INCH -> 1.50;
        }) : 0.0);
    }
}
