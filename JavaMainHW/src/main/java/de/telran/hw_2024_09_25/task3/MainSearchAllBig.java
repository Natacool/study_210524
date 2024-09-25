package de.telran.hw_2024_09_25.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainSearchAllBig {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("BigBen", "BigBob", "Big", "Ben", "Big Bob");
        System.out.println(list);

        long amount = list.stream()
                .filter(p -> p.contains("Big"))
                .count();
        System.out.println(amount);

    }
}
