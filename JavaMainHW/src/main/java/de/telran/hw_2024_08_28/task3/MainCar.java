package de.telran.hw_2024_08_28.task3;

public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car("VW", "black", "1.5L", "Bart");
        Car car2 = new Car("BMW", "blue", "2.0L", "Ahmed");

        Driver driver1 = car1;
        car1.drive();
        car1.setNumber("B 2525 TF");

        car1.sale("Sebastian");
        car1.changeNumber("B 777 MW");
        car1.changeEngine("1.8L");
        car1.drive();


        Mechanic mechanic = car2;
        car2.repair();
        car2.changeEngine("2.4L");
        car2.recolor("red");
        car2.drive();
    }
}
