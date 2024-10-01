package de.telran.hw_2024_09_02.task2;

import java.util.concurrent.ScheduledExecutorService;

public class CoffeeMachine {
    int coffee =0;
    int milk=0;
    int water=0;
    private static CoffeeMachine coffeeMachine = null;

    private CoffeeMachine() {
    }

     public static CoffeeMachine getCoffeeMachine(){
        if (coffeeMachine == null)
            coffeeMachine = new CoffeeMachine();
        return coffeeMachine;
     }

     private boolean checkIngredients(CoffeeEnum coffeeType){
        boolean ingredients = false;
        if (this.coffee >= coffeeType.getCoffee()
            && this.water >= coffeeType.getWater()
            && this.milk >= coffeeType.getMilk()){
            ingredients = true;
        }
        return ingredients;
     }

     public void makeCoffee(CoffeeEnum coffeeType){
        if (checkIngredients(coffeeType)){
            this.coffee = this.coffee - coffeeType.getCoffee();
            this.water = this.water - coffeeType.getWater();
            this.milk = this.milk - coffeeType.getMilk();
            System.out.println(coffeeType.getTitle() + " is ready, take it please.");
        }
        else {
            System.out.println("Can't prepare [" + coffeeType
                    + "] because not enough ingredients:");
            System.out.print("coffee: " + this.coffee + " gr, ");
            System.out.print("water: " + this.water + " ml, ");
            System.out.println("milk: " + this.milk + " ml.");

            System.out.println("Required for [" + coffeeType.getTitle() + "]:");
            System.out.print("coffee: " + coffeeType.getCoffee() + " gr, ");
            System.out.print("water: " + coffeeType.getWater() + " ml, ");
            System.out.println("milk: " + coffeeType.getMilk() + " ml.");
        }
     }

     public void addCoffee(int coffee){
        if (coffee > 50) this.coffee = 50;
        else this.coffee = coffee;
         System.out.println("Added " + this.coffee + " gram coffee. Maximum 50 gr.");
     }

    public void addWater(int water){
        if (water > 400) this.water = 400;
        else this.water = water;
        System.out.println("Added " + this.water + " ml water. Maximum 400 ml.");
    }

    public void addMilk(int milk){
        if (milk > 200) this.milk = 200;
        else this.milk = milk;
        System.out.println("Added " + this.milk + " ml milk. Maximum 200 ml.");
    }

}
