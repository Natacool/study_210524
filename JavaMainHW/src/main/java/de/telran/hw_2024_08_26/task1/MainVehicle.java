package de.telran.hw_2024_08_26.task1;

public class MainVehicle {
    public static void main(String[] args) {
        System.out.println("vehicles:");

        Airplane airplane = new Airplane();
        airplane.fly();
        airplane.cargoTransport();
        airplane.peopleTransport();
        airplane.repair();
        airplane.service();

        Bus bus = new Bus();
        bus.movementRoad();
        bus.peopleTransport();
        bus.repair();
        bus.service();

        Car car = new Car();
        car.movementRoad();
        car.peopleTransport();
        car.repair();
        car.service();

        CargoShip cargoShip = new CargoShip();
        cargoShip.swim();
        cargoShip.cargoTransport();
        cargoShip.repair();
        cargoShip.service();

        CruiseShip cruiseShip = new CruiseShip();
        cruiseShip.swim();
        cruiseShip.peopleTransport();
        cruiseShip.repair();
        cruiseShip.service();

        FerryShip ferry = new FerryShip();
        ferry.swim();
        ferry.peopleTransport();
        ferry.cargoTransport();
        ferry.repair();
        ferry.service();

        Truck truck = new Truck();
        truck.movementRoad();
        truck.cargoTransport();
        truck.repair();
        truck.service();

    }
}
