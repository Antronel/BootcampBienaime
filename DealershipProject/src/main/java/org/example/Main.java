package org.example;


public class Main {
        public static void main(String[] args) {
            String inventory = "csv/Book1.csv";
            String contract = "contracts.csv";

            UserInterface ui = new UserInterface(inventory, contract);
            ui.display();
        }
    }