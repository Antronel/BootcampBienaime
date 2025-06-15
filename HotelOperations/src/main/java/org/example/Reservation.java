package org.example;

public class Reservation {
    private int numberOfNights;
    private String roomType;
    private double price;
    private boolean isWeekend;

    public Reservation(int numberOfNights, String roomType, boolean isWeekend) {
        this.numberOfNights = numberOfNights;
        this.roomType = roomType;
        this.isWeekend = isWeekend;
        setPriceByRoomType(); // << important!
}

    // Set base price depending on room type
    private void setPriceByRoomType() {
        if (roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            price = 124.00;
        } else {
            price = 0.00; // default if room type is invalid but I need to ask Jon if this is per night
        }
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Setter for room type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
        setPriceByRoomType(); // update price if room type changes

    }

    // Getter for price per night (adjusted for weekend)
    public double getPrice() {
        if (isWeekend) {
            return price * 1.10; // 10% increase
        }
        return price;
    }

    // Getter and setter for number of nights
    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getter and setter for isWeekend
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    // Calculate total price for the stay
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}




