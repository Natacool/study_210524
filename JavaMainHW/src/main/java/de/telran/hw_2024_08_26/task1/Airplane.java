package de.telran.hw_2024_08_26.task1;

public class Airplane
    extends Vehicle
    implements Flyable,
    CargoTransportable,
    PeopleTransportable {

    @Override public
    void repair(){
        System.out.println("repair Airplane");
    }

    @Override public
    void service(){
        System.out.println("service Airplane");
    }

    @Override public
    void fly(){
        System.out.println("Airplane can fly");
    }

    @Override public
    void cargoTransport() { System.out.println("Airplane can transport cargo"); }

    @Override public
    void peopleTransport() { System.out.println("Airplane can transport people"); }

}
