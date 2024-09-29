package de.telran.hw_2024_08_30.task2;

public class Car extends Automobil {
    int passengers;
    public Car(String model, String number, int year, int passengers) {
        super(model, number, year);
        this.passengers = passengers;
    }

    public void work(){
        System.out.println("This car can transport up to " + passengers + " passengers.");
    }

}
