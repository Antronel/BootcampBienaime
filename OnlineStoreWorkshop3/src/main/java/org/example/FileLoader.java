package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    private static final String FILE_PATH = "src/main/resources/ExoticPets.csv";
    private static final String DELIMITER = "\\|";

    public static List<Product> readFile() {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Skip header
            bufferedReader.readLine();
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split(DELIMITER);
                if (row.length < 4) {
                    System.out.println("Malformed row: " + input);
                    continue;
                }

                try {
                    String sku = row[0];
                    String productName = row[1];
                    double price = Double.parseDouble(row[2]);
                    String department = row[3];
                    Product product = new Product(sku, productName, price, department);
                    productList.add(product);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price in row: " + input);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("CSV file not found: " + FILE_PATH);
        } catch (IOException ex) {
            System.out.println("Failed to read CSV file: " + ex.getMessage());
        }

        if (productList.isEmpty()) {
            System.out.println("No products found in the CSV file.");
        }

        return productList;
    }
}