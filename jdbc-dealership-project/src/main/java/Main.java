package com.pluralsight


public class Main {
        public static void main(String[] args) {
            String inventory = "csv/Book1.csv";
            String contract = "contracts.csv";

            org.example.UserInterface ui = new org.example.UserInterface(inventory, contract);
            ui.display();
        }
    }

