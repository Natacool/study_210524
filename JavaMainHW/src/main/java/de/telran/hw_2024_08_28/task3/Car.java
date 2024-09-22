package de.telran.hw_2024_08_28.task3;

public class Car
    implements Driver, Mechanic {
    private String model;
    private String color;
    private String engine;
    private String number;
    private String owner;

    public Car(String model, String color, String engine, String owner) {
        this.model = model;
        this.color = color;
        this.owner = owner;
        this.engine = engine;
        System.out.println(this.owner + " owns " + this.color + " " + this.model + ", number: " + this.number + " engine: " + this.engine);
    }


    // Driver
    public void drive(){
        System.out.println(owner + " drives " + this.color + " " + this.model + " engine: " + this.engine);
    }

    public void sale(String newOwner){
        System.out.println(this.owner + " sales " + this.color + " " + this.model + " to " + newOwner);
        this.owner = newOwner;
        System.out.println(this.owner + " owns " + this.color + " " + this.model + ", number: " + this.number);
    }

    public void changeNumber(String newNumber){
        System.out.println(this.owner + " changed number, old number: "+ this.number + ", new number: " + newNumber);
        this.number = newNumber;
    }

    public void setNumber(String number){
        System.out.println(this.owner + " got number, old number: "+ this.number + ", new number: " + number);
        this.number = number;
    }


    // Mechanic
    public void recolor(String newColor){
        System.out.println("Mechanic changed color from " + this.color + " to " + newColor);
        this.color = newColor;
    }

    public void changeEngine(String newEngine){
        System.out.println("Mechanic changed engine from " + this.engine + " to " + newEngine);
        this.engine = newEngine;
    }

    public void repair(){
        System.out.println("Mechanic can check/service/repair " + this.color + " " + this.model);
    }

}
