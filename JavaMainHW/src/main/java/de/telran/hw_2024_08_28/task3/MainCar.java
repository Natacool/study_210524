package de.telran.hw_2024_08_28.task3;

public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car("VW", "black", "1.5L", "Bart");
        Car car2 = new Car("BMW", "blue", "2.0L", "Ahmed");

        Driver driver1 = car1;
        driver1.drive();
        driver1.setNumber("B 2525 TF");

        driver1.sale("Sebastian");
        driver1.changeNumber("B 777 MW");
        driver1.drive();


        Mechanic mechanic = car2;
        mechanic.repair();
        mechanic.changeEngine("2.4L");
        mechanic.recolor("red");

    }
}
