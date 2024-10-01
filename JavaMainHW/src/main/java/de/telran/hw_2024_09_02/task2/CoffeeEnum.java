package de.telran.hw_2024_09_02.task2;

public enum CoffeeEnum {
    ESPRESSO("Espresso", 10, 30, 0), // 7 gr cofee, 30 ml water // 1:2
    DOUBLE_ESPRESSO("Double Espresso", 20, 60, 0), // 14 gr coffee, 60 ml water
    AMERICANO("Americano", 10, 100, 0), // 7 gr coffee, 100 ml water
    CAPPUCCINO("Cappuccino", 10, 30, 100), // 7 gr coffee, 30 ml water, 110 ml milk
    LATTE("Latte", 10, 30, 200); // 7 gr coffee, 30 ml water, 210 ml milk

    private String title;
    private int coffee;
    private int water;
    private int milk;

    CoffeeEnum(String title, int coffee, int water, int milk) {
        this.title = title;
        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
    }

    public String getTitle() {
        return title;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }
}
