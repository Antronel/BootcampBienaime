package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the initial deposit?");
                double p = scanner.nextDouble();
                System.out.println("What is your annual interest rate?");
                double dr = scanner.nextDouble();
                double r = dr / 100;
                System.out.println("What is the number of years invested before withdraw?");
                double t = scanner.nextDouble();


                //FV = P(1 + r/n)^(n*t)
                double l = r/365;
                double a = Math.pow((l+1),(365 * t ));
                double fv =a * p;
                double interest = fv-p;
                System.out.printf("Your future value is $%.2f, with total interest of $%.2f",fv, interest);
    }
}