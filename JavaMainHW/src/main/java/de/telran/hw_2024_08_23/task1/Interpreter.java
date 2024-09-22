package de.telran.hw_2024_08_23.task1;

public abstract class Interpreter {
    String name;
    int age;
    char gender;
    String language1;
    String language2;

    public Interpreter(String name, int age, char gender, String language1, String language2) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.language1 = language1;
        this.language2 = language2;
    }

    void translate(){
        if (this.gender == 'F')
        {
            System.out.print(this.name + " - woman, " + this.age + " years old ");
        }
        else
        {
            System.out.print(this.name + "  - man, " + this.age + " years old");
        }
        System.out.println(" can translate from " + this.language1 + " to " + this.language2 + " and vice versa.");
    }

}
