package org.example;

public class CircleMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5);

        System.out.println("The circumference of the circle is " + circle.getCircumference());
        System.out.println("The diameter of the circle is " + circle.getDiameter());
    }
}
