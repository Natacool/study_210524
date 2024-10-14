package de.telran.hw_2024_09_16.task1;

import java.util.Comparator;

public class SortByArea implements Comparator<House> {
    @Override
    public int compare(House h1, House h2) {
        if (h1.getArea() < h2.getArea()) return 1;
        else if (h1.getArea() > h2.getArea()) return -1;
        else return 0;
    }
}
