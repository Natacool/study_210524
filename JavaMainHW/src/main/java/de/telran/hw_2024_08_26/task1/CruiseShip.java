package de.telran.hw_2024_08_26.task1;

public class CruiseShip
    extends Vehicle
    implements Swimmable,
    PeopleTransportable{

    @Override public
    void repair(){ System.out.println("repair CruiseShip"); }

    @Override public
    void service(){ System.out.println("service CruiseShip"); }

    @Override public
    void swim(){ System.out.println("CruiseShip can swim through sea"); }

    @Override public
    void peopleTransport(){ System.out.println("CruiseShip can transport people"); }
}
