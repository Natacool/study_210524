package de.telran.hw_2024_09_13.task1;

import java.util.Objects;

public class Human {
    private String name;
    private String eye;
    private Integer age;

    public Human(String name, String eye, Integer age) {
        this.name = name;
        this.eye = eye;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEye() {
        return eye;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human: " +
                "name=" + this.name +
                ", eye=" + this.eye +
                ", age='" + this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human man = (Human) o;
        return this.age == man.age
                && Objects.equals(this.name, man.name)
                && Objects.equals(this.eye, man.eye);
    }
}
