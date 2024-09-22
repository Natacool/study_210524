package de.telran.hw_2024_08_26.task1;

public class Car
    extends Vehicle
    implements Movable,
    PeopleTransportable {

    @Override public
    void repair(){
        System.out.println("repair Car");
    }

    @Override public
    void service(){
        System.out.println("service Car");
    }

    @Override public
    void movementRoad(){
        System.out.println("Car can drive on a road");
    }

    @Override public
    void peopleTransport(){ System.out.println("Car can transport people"); }

}
