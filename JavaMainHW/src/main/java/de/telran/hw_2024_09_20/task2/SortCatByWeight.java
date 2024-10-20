package de.telran.hw_2024_09_20.task2;

import java.util.Comparator;

public class SortCatByWeight implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        if (c1.getWeight() < c2.getWeight()) return 1;
        else if (c1.getWeight() > c2.getWeight()) return -1;
        else return 0;
    }
}
