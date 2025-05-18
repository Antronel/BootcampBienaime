package org.example;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Models.Vehicle vehicle;

    public Contract(String date, String customerName, String customerEmail, Models.Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Models.Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Models.Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    // Method to convert contract to a string format for file storage
    public abstract String toFileString();
}