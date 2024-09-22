package de.telran.hw_2024_08_19.task2;

public class Phone {
    String number;
    String model;
    int weight;

    void receiveCall(String name){
        System.out.println(name + " is calling!");
    }

    String getNumber(){
        return this.number;
    }
}
