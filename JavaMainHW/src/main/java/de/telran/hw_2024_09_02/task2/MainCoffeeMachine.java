package de.telran.hw_2024_09_02.task2;

public class MainCoffeeMachine {
    public static void main(String[] args) {
        System.out.println("New coffee machine !!! ");
        CoffeeMachine cm = CoffeeMachine.getCoffeeMachine();
        cm.makeCoffee(CoffeeEnum.AMERICANO);
        cm.addCoffee(30);
        cm.addWater(200);
        cm.addMilk(200);

        System.out.println("Prepare requested coffee...");
        cm.makeCoffee(CoffeeEnum.AMERICANO);
        cm.makeCoffee(CoffeeEnum.CAPPUCCINO);
        cm.makeCoffee(CoffeeEnum.LATTE);

        System.out.println("");
        System.out.println("New coffee machine ??? ");
        CoffeeMachine cm1 = CoffeeMachine.getCoffeeMachine();
        cm1.makeCoffee(CoffeeEnum.LATTE);
        cm1.addMilk(200);
        cm1.makeCoffee(CoffeeEnum.LATTE);

    }
}
