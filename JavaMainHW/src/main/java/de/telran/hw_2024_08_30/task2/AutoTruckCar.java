package de.telran.hw_2024_08_30.task2;

public class AutoTruckCar extends  Car{
    Truck truck;
    public AutoTruckCar(String model, String number, int year, int passengers, int cargo_kg) {
        super(model, number, year, passengers);
        truck = new Truck(model, number, year, cargo_kg);
    }

    public void work(){
        System.out.println("This car can transport up to " + super.passengers + " passengers.");
        System.out.println("This car can transport up to " + truck.cargo_kg + " kg of cargo.");
    }

}
