package de.telran.hw_2024_08_26.task1;

public class Bus
    extends Vehicle
    implements Movable,
    PeopleTransportable {

    @Override public
    void repair() { System.out.println("repair Bus"); }

    @Override public
    void service() { System.out.println("service Bus"); }

    @Override public
    void movementRoad() { System.out.println("Bus can drive on a road"); }

    @Override public
    void peopleTransport() { System.out.println("Bus can transport people"); }

}
