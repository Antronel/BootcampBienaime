package org.example;

public class Car {
    //miles per hour
    private double speed;
    private double fuelLevel;
    private double maxFuelCapacity;

    public Car(double maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
        this.fuelLevel = maxFuelCapacity;
        this.speed = 0;
    }

    public void accelerate( ) {
        if (isFuelLevelEmpty() == false) {
            this.speed = speed + 5;
        }

        //helper method or private method


    }
    private boolean isFuelLevelEmpty() {
            return fuelLevel <= 0;

    }
}
