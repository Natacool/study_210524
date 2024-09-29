package de.telran.hw_2024_08_30.task2;

public class Truck extends Automobil {
    int cargo_kg;
    public Truck(String model, String number, int year, int cargo_kg) {
        super(model, number, year);
        this.cargo_kg = cargo_kg;
    }

    public void work(){
        System.out.println("This car can transport up to " + cargo_kg + " kg of cargo.");
    }
}
