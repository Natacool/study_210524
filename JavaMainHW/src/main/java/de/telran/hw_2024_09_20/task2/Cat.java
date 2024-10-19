package de.telran.hw_2024_09_20.task2;

public class Cat implements Comparable<Cat>{
    private String name;
    private int age;
    private int weight;
    private String breed;

    public Cat(String name, int age, int weight, String race) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = race;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public int compareTo(Cat cat) {
        if(this.age > cat.getAge()) return 1;
        else if(this.age < cat.getAge()) return -1;
        else return 0;
    }
}
