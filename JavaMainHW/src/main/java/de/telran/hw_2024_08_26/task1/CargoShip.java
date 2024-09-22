package de.telran.hw_2024_08_26.task1;

public class CargoShip
        extends Vehicle
        implements Swimmable,
        CargoTransportable {

    @Override public
    void repair(){
        System.out.println("repair CargoShip");
    }

    @Override public
    void service(){
        System.out.println("service CargoShip");
    }

    @Override public
    void cargoTransport(){
            System.out.println("CargoShip can transport cargo");
        }

    @Override public
    void swim(){
        System.out.println("CargoShip can swim through sea");
    }
}
