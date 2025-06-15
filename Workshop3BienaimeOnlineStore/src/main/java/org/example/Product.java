package org.example;

public class Product {
    private String id;
    private String species;
    private double price;
    private String habitat;

    public Product(String id, String species, double price, String habitat) {
        this.id = id;
        this.species = species;
        this.price = price;
        this.habitat = habitat;
    }

    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public double getPrice() {
        return price;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return "ExoticPet{" +
                "id='" + id + '\'' +
                ", species='" + species + '\'' +
                ", price=" + price +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
