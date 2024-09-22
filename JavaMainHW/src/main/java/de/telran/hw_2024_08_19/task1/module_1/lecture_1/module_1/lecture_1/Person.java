package de.telran.hw_2024_08_19.task1.module_1.lecture_1.module_1.lecture_1;

public class Person {
    int age;
    String fullName;

    public Person() {
        //this.age = 32;
        //this.fullName = "Jastin Biver";
    }

    public Person(String fullName, int age) {
        this.age = age;
        this.fullName = fullName;
    }

    void move(){
        System.out.println(this.fullName + " speaks!");
    }

    void talk(){
        System.out.println(this.fullName + " runs!");
    }


}
