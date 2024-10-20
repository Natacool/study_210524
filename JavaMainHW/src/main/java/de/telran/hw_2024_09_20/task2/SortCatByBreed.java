package de.telran.hw_2024_09_20.task2;

import java.util.Comparator;

public class SortCatByBreed implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return c1.getBreed().compareTo(c2.getBreed());
    }
}
