package org.example;

public abstract class Topping {
    public Topping(String name, boolean isExtra) {
    }

    public abstract double getPrice(Size size);

    public char[] getName() {
        return new char[0];
    }

}
