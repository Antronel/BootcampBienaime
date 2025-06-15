

package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private static final String FILE_PATH = "src/main/resources/exotic_pets.csv";

    public static List<ExoticPet> readFile() {
        List<ExoticPet> petList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            bufferedReader.readLine(); // Skip header line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split("\\|");
                petList.add(parsePet(row));
            }
        } catch (IOException ex) {
            System.out.println("Failed to load exotic pets CSV file.");
        }
        return petList;
    }

    private static ExoticPet parsePet(String[] row) {
        String id = row[0];
        String species = row[1];
        double price = Double.parseDouble(row[2]);
        String habitat = row[3];
        return new ExoticPet(id, species, price, habitat);
    }
}
