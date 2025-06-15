<<<<<<< HEAD
package com.pluralsight

import org.example.Contract;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private static final double PROCESSING_FEE_UNDER_10K = 295.0;
    private static final double PROCESSING_FEE_10K_OR_MORE = 495.0;
    private static final double INTEREST_RATE_UNDER_10K = 0.0525;
    private static final double INTEREST_RATE_10K_OR_MORE = 0.0425;
    private static final int LOAN_TERM_UNDER_10K = 24;
    private static final int LOAN_TERM_10K_OR_MORE = 48;

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, org.example.Models.Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTaxAmount = vehicle.getPrice() * SALES_TAX_RATE;
        this.recordingFee = RECORDING_FEE;
        this.processingFee = (vehicle.getPrice() < 10000) ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_10K_OR_MORE;
        this.isFinanced = isFinanced;
    }

    // Getters and setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0.0;
        }

        double vehiclePrice = getVehicle().getPrice();
        double interestRate;
        int loanTerm;

        if (vehiclePrice >= 10000) {
            interestRate = INTEREST_RATE_10K_OR_MORE;
            loanTerm = LOAN_TERM_10K_OR_MORE;
        } else {
            interestRate = INTEREST_RATE_UNDER_10K;
            loanTerm = LOAN_TERM_UNDER_10K;
        }

        double monthlyInterestRate = interestRate / 12;
        double totalPrice = getTotalPrice();

        // Monthly payment formula: P * (r(1+r)^n) / ((1+r)^n - 1)
        // where P is principal, r is monthly interest rate, n is number of payments
        return totalPrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm))
                / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);
    }

    @Override
    public String toFileString() {
        return "SALE|" +
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
                salesTaxAmount + "|" +
                recordingFee + "|" +
                processingFee + "|" +
                getTotalPrice() + "|" +
                (isFinanced ? "YES" : "NO") + "|" +
                getMonthlyPayment();
    }
=======
package com.pluralsight

import org.example.Contract;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private static final double PROCESSING_FEE_UNDER_10K = 295.0;
    private static final double PROCESSING_FEE_10K_OR_MORE = 495.0;
    private static final double INTEREST_RATE_UNDER_10K = 0.0525;
    private static final double INTEREST_RATE_10K_OR_MORE = 0.0425;
    private static final int LOAN_TERM_UNDER_10K = 24;
    private static final int LOAN_TERM_10K_OR_MORE = 48;

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, org.example.Models.Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTaxAmount = vehicle.getPrice() * SALES_TAX_RATE;
        this.recordingFee = RECORDING_FEE;
        this.processingFee = (vehicle.getPrice() < 10000) ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_10K_OR_MORE;
        this.isFinanced = isFinanced;
    }

    // Getters and setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0.0;
        }

        double vehiclePrice = getVehicle().getPrice();
        double interestRate;
        int loanTerm;

        if (vehiclePrice >= 10000) {
            interestRate = INTEREST_RATE_10K_OR_MORE;
            loanTerm = LOAN_TERM_10K_OR_MORE;
        } else {
            interestRate = INTEREST_RATE_UNDER_10K;
            loanTerm = LOAN_TERM_UNDER_10K;
        }

        double monthlyInterestRate = interestRate / 12;
        double totalPrice = getTotalPrice();

        // Monthly payment formula: P * (r(1+r)^n) / ((1+r)^n - 1)
        // where P is principal, r is monthly interest rate, n is number of payments
        return totalPrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm))
                / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1);
    }

    @Override
    public String toFileString() {
        return "SALE|" +
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
                salesTaxAmount + "|" +
                recordingFee + "|" +
                processingFee + "|" +
                getTotalPrice() + "|" +
                (isFinanced ? "YES" : "NO") + "|" +
                getMonthlyPayment();
    }
>>>>>>> b4c7cd8 (Add jdbc-dealership-project files)
}