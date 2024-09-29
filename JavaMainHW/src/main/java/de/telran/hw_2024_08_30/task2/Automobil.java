package de.telran.hw_2024_08_30.task2;

public abstract class Automobil {
    String model;
    String number;
    int year;

    public Automobil(String model, String number, int year) {
        this.model = model;
        this.number = number;
        this.year = year;
        System.out.println("This car: " + model + ", created " + year + ", number: " + number);
    }
}
