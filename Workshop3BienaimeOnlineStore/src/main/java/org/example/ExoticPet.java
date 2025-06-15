package org.example;

public class ExoticPet {

    public ExoticPet(String id, String species, double price, String habitat) {
    }

    public static class exoticPet {
        private String id;
        private String species;
        private double price;
        private String habitat;

        public exoticPet(String id, String species, double price, String habitat) {
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
    }

}
