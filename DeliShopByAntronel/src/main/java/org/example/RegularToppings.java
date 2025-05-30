package org.example;

class RegularTopping extends Topping {
    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {
        return 0.0; // Regular toppings are free
    }
}