package de.telran.hw_2024_09_25.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainFindLow {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "b5", "a2", "b4");
        System.out.println(list);

        List<String> listResult = list.stream()
                .sorted()
                .limit(1)
                .toList();
        System.out.println(listResult);

    }
}
