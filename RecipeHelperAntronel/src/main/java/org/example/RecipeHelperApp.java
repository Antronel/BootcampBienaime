package org.example;

public class RecipeHelperApp {
    public static void main(String[] args) {
        // Test the conversion methods with the team but call jon if needed
        double cups = 2.0;
        double tablespoons = 3.5;
        double teaspoons = 4.0;

        // format the output with no more than 2 decimal places
        System.out.printf("%.1f cups = %.2f ml%n", cups, RecipeHelper.cupsToMilliliters(cups));
        //System.out.println(cups + " cups = " + RecipeHelper.cupsToMilliliters(cups) + " ml");
        System.out.println(tablespoons + " tablespoons = " + RecipeHelper.tablespoonsToMilliliters(tablespoons) + " ml");
        System.out.println(teaspoons + " teaspoons = " + RecipeHelper.teaspoonsToMilliliters(teaspoons) + " ml");
    }
}

