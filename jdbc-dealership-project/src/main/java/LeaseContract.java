<<<<<<< HEAD
package org.example;

import com.pluralsight.Contract;

public class LeaseContract extends Contract {
    private static final double EXPECTED_END_VALUE_RATE = 0.5; // 50% of original price
    private static final double LEASE_FEE_RATE = 0.07; // 7% of original price
    private static final double LEASE_INTEREST_RATE = 0.04; // 4.0%
    private static final int LEASE_TERM_MONTHS = 36; // 36 months

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, org.example.Models.Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * EXPECTED_END_VALUE_RATE;
        this.leaseFee = vehicle.getPrice() * LEASE_FEE_RATE;
    }

    // Getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        // Total price for a lease is vehicle price - expected ending value + lease fee
        return getVehicle().getPrice() - expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyInterestRate = LEASE_INTEREST_RATE / 12;

        // Monthly payment formula: P * (r(1+r)^n) / ((1+r)^n - 1)
        // where P is principal, r is monthly interest rate, n is number of payments
        return totalPrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, LEASE_TERM_MONTHS))
                / (Math.pow(1 + monthlyInterestRate, LEASE_TERM_MONTHS) - 1);
    }

    @Override
    public String toFileString() {
        return "LEASE|" +
                getDate() + "|" +
                getCustomerName() + "|" +
                getCustomerEmail() + "|" +
                getVehicle().getVin() + "|" +
                getVehicle().getYear() + "|" +
                getVehicle().getMake() + "|" +
                getVehicle().getModel() + "|" +
                getVehicle().getType() + "|" +
                getVehicle().getColor() + "|" +
                getVehicle().getOdometer() + "|" +
                getVehicle().getPrice() + "|" +
                expectedEndingValue + "|" +
                leaseFee + "|" +
                getTotalPrice() + "|" +
                getMonthlyPayment();
    }
=======
package org.example;

import com.pluralsight.Contract;

public class LeaseContract extends Contract {
    private static final double EXPECTED_END_VALUE_RATE = 0.5; // 50% of original price
    private static final double LEASE_FEE_RATE = 0.07; // 7% of original price
    private static final double LEASE_INTEREST_RATE = 0.04; // 4.0%
    private static final int LEASE_TERM_MONTHS = 36; // 36 months

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, org.example.Models.Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * EXPECTED_END_VALUE_RATE;
        this.leaseFee = vehicle.getPrice() * LEASE_FEE_RATE;
    }

    // Getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        // Total price for a lease is vehicle price - expected ending value + lease fee
        return getVehicle().getPrice() - expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyInterestRate = LEASE_INTEREST_RATE / 12;

        // Monthly payment formula: P * (r(1+r)^n) / ((1+r)^n - 1)
        // where P is principal, r is monthly interest rate, n is number of payments
        return totalPrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, LEASE_TERM_MONTHS))
                / (Math.pow(1 + monthlyInterestRate, LEASE_TERM_MONTHS) - 1);
    }

    @Override
    public String toFileString() {
        return "LEASE|" +
                getDate() + "|" +
                getCustomerName() + "|" +
                getCustomerEmail() + "|" +
                getVehicle().getVin() + "|" +
                getVehicle().getYear() + "|" +
                getVehicle().getMake() + "|" +
                getVehicle().getModel() + "|" +
                getVehicle().getType() + "|" +
                getVehicle().getColor() + "|" +
                getVehicle().getOdometer() + "|" +
                getVehicle().getPrice() + "|" +
                expectedEndingValue + "|" +
                leaseFee + "|" +
                getTotalPrice() + "|" +
                getMonthlyPayment();
    }
>>>>>>> b4c7cd8 (Add jdbc-dealership-project files)
}