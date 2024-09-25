package de.telran.hw_2024_09_25.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainReverseSortDelDup {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        System.out.println(list);

        List<String> listResult = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(listResult);

    }
}
