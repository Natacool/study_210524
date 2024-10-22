package de.telran.hw_2024_09_23.task2;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainLambda {
    public static void main(String[] args) {
        Predicate<String> predicate  = (s) -> s != null;
        System.out.println("Predicate s != null: "+predicate.test(null));
        System.out.println("Predicate s != null: "+predicate.test("null"));
        System.out.println("Predicate s != null: "+predicate.test(""));

        predicate  = (s) -> s.length() != 0;
        System.out.println("Predicate s is not empty: "+predicate.test("null"));
        System.out.println("Predicate s is not empty: "+predicate.test(""));

        predicate  = (s) -> {
            return (s.charAt(0) == 'J' || s.charAt(0) == 'N')
                    && s.charAt(s.length()-1) == 'A';
        };
        System.out.println("Predicate NULL begins J or A and ends N: "
                +predicate.test("NULL"));
        System.out.println("Predicate NIMDA begins J or A and ends N: "
                +predicate.test("NIMDA"));

        Function<Integer, String> num = x-> {
            if(x > 0) return "Положительное число";
            else if (x < 0) return "Отрицательное число";
            else return "Ноль";
        };
        System.out.println("-3 - " + num.apply(-3));
        System.out.println("7 - " + num.apply(7));
        System.out.println("0 - " + num.apply(0));

        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            return random.nextInt(11);
        };
        System.out.println("Random: " + supplier.get());


    }
}
