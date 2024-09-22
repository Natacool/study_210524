package de.telran.hw_2024_08_26.task1;

public class Truck
    extends Vehicle
    implements Movable,
    CargoTransportable {

    @Override public
    void repair(){
        System.out.println("repair Truck");
    }

    @Override public
    void service(){
        System.out.println("service Truck");
    }

    @Override public
    void cargoTransport(){ System.out.println("Truck can move cargo"); }

    @Override public
    void movementRoad(){
        System.out.println("Truck can drive on a road");
    }

}
