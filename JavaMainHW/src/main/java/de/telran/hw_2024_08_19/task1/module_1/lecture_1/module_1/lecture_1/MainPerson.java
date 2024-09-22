package de.telran.hw_2024_08_19.task1.module_1.lecture_1.module_1.lecture_1;

public class MainPerson {
    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println("Person: " + person1.fullName + " ,age: " + person1.age);
        person1.move();
        person1.talk();

        Person person2 = new Person("Snoop Dog", 23);
        System.out.println("Person: " + person2.fullName + " ,age: " + person2.age);
        person2.move();
        person2.talk();

    }
}
