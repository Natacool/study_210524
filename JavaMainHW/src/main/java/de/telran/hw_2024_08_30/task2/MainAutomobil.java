package de.telran.hw_2024_08_30.task2;

public class MainAutomobil {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "B2323FE", 2020, 4);
        car1.work();
        Truck truck1 = new Truck("MAN", "B111ER", 2010, 3000);
        truck1.work();

        AutoTruckCar auto = new AutoTruckCar("MB Viano", "B777MB", 2023 , 5, 500);
        auto.work();
    }
}
