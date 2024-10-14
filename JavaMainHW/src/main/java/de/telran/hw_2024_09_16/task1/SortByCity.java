package de.telran.hw_2024_09_16.task1;

import java.util.Comparator;

public class SortByCity implements Comparator<House> {
    @Override
    public int compare(House h1, House h2) {
        return h1.getCity().compareTo(h2.getCity());
    }
}
