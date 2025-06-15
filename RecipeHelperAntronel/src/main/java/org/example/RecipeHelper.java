package org.example;

public class RecipeHelper {

    // Conversion constants or into the asked of Jon
    private static final double CUPS_TO_MILLILITERS = 236.588;
    private static final double TABLESPOONS_TO_MILLILITERS = 14.7868;
    private static final double TEASPOONS_TO_MILLILITERS = 4.92892;

    // Static method to convert cups to milliliters
    public static double cupsToMilliliters(double cups) {
        return cups * CUPS_TO_MILLILITERS;
    }

    // Static method to convert tablespoons to milliliters
    public static double tablespoonsToMilliliters(double tablespoons) {
        return tablespoons * TABLESPOONS_TO_MILLILITERS;
    }

    // Static method to convert teaspoons to milliliters
    public static double teaspoonsToMilliliters(double teaspoons) {
        return teaspoons * TEASPOONS_TO_MILLILITERS;
    }
}
