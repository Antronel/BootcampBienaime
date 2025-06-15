package org.example;

public class Main {
    public static void main(String[] args) {
Reservation reservation = new Reservation(5, "double", true);
System.out.println(reservation.getReservationTotal());
    }
}