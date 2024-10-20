package de.telran.hw_2024_09_20.task2;

import de.telran.hw_2024_09_16.task1.House;

import java.util.Comparator;

public class SortCatByName implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
//        if (h1.getArea() < h2.getArea()) return 1;
//        else if (h1.getArea() > h2.getArea()) return -1;
//        else return 0;
        return c1.getName().compareTo(c2.getName());

    }

}
