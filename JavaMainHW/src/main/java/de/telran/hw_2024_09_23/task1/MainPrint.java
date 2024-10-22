package de.telran.hw_2024_09_23.task1;

import java.util.function.Consumer;

public class MainPrint {
    public static void main(String[] args) {
        Printable printCapital = (s) -> {
            System.out.println(s.toUpperCase());
        };

        Printable printLower = (s) -> {
            System.out.println(s.toLowerCase());
        };

        printCapital.print("QweQweQwe");
        printLower.print("QweQweQwe");

        Consumer<String> printCap = s -> System.out.println("Capital:  " + s.toUpperCase());
        printCap.accept("QweQweQwe");

        Consumer<String> printLow = s -> System.out.println("Low:  " + s.toLowerCase());
        printLow.accept("QweQweQwe");
    }
}
