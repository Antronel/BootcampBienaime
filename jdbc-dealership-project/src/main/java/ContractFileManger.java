package com.pluralsight

import org.example.Contract;
import org.example.LeaseContract;
import org.example.SalesContract;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ContractFileManager {
    private final String contractsFile;

    public ContractFileManager(String contractsFile) {
        this.contractsFile = contractsFile;
    }

    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(contractsFile, true))) {
            // Append the contract to the file
            writer.println(contract.toFileString());
        } catch (IOException e) {
            System.err.println("Error writing to contracts file: " + e.getMessage());
        }
    }
}