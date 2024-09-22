package de.telran.hw_2024_08_26.task1;

public class FerryShip
    extends Vehicle
    implements Swimmable,
    Transportable {

    @Override public
    void repair(){
        System.out.println("repair FerryShip");
    }

    @Override public
    void service(){
        System.out.println("service FerryShip");
    }

    @Override public
    void cargoTransport(){ System.out.println("FerryShip can transport cargo"); }

    @Override public
    void peopleTransport(){ System.out.println("FerryShip can transport people"); }

    @Override public
    void swim(){
        System.out.println("FerryShip can swim through sea");
    }

}
