package de.telran.hw_2024_09_16.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainHouse {
    public static void main(String[] args) {
        House house01 = new House("Berlin", 75, 600000, false);
        House house02 = new House("Berlin", 64, 390000, false);
        House house03 = new House("Berlin", 64, 390000, false);
        House house04 = new House("Berlin", 120, 1400000, true);
        House house05 = new House("Dresden", 75, 350000, true);
        House house06 = new House("Dresden", 75, 300000, false);
        House house07 = new House("Dresden", 72, 300000, false);
        House house08 = new House("Hamburg", 48, 240000, false);
        House house09 = new House("Hamburg", 55, 300000, false);
        House house10 = new House("Hamburg", 55, 300000, false);
        House house11 = new House("Hamburg", 75, 600000, true);
        House house12 = new House("Hamburg", 75, 400000, false);
        House house13 = new House("Munich", 62, 800000, false);
        House house14 = new House("Stuttgart", 42, 320000, false);
        House house15 = new House("Stuttgart", 45, 300000, false);
        House house16 = new House("Bonn", 54, 380000, false);
        House house17 = new House("Bonn", 45, 280000, false);
        House house18 = new House("Bremen", 60, 300000, false);
        House house19 = new House("Leipzig", 45, 230000, false);
        House house20 = new House("Frankfurt", 75, 900000, true);

        ArrayList<House> realEstate = new ArrayList<>();
        realEstate.add(house01);
        realEstate.add(house02);
        realEstate.add(house03);
        realEstate.add(house04);
        realEstate.add(house05);
        realEstate.add(house06);
        realEstate.add(house07);
        realEstate.add(house08);
        realEstate.add(house09);
        realEstate.add(house10);
        realEstate.add(house11);
        realEstate.add(house12);
        realEstate.add(house13);
        realEstate.add(house14);
        realEstate.add(house15);
        realEstate.add(house16);
        realEstate.add(house17);
        realEstate.add(house18);
        realEstate.add(house19);
        realEstate.add(house20);

        System.out.println(" --- non sorted --- ");
        System.out.println("ArrayList<House> realEstate: " + realEstate);


        System.out.println(" --- sorted by default --- ");
        Collections.sort(realEstate);
        System.out.println("ArrayList<House> realEstate: " + realEstate);

        System.out.println(" --- sorted by city --- ");
        Comparator<House> houseComparatorByCity = new SortByCity();
        realEstate.sort(houseComparatorByCity);
        System.out.println("ArrayList<House> realEstate: " + realEstate);

        System.out.println(" --- sorted by city, then price --- "); // check Stuttgart flats
        Comparator<House> houseComparatorByCityAndPrice = houseComparatorByCity.thenComparing(new SortByPrice());
        realEstate.sort(houseComparatorByCityAndPrice);
        System.out.println("ArrayList<House> realEstate: " + realEstate);

        System.out.println(" --- sorted by city, then area --- "); // check Stuttgart flats
        Comparator<House> houseComparatorByCityAndArea = houseComparatorByCity.reversed().thenComparing(new SortByArea());
        realEstate.sort(houseComparatorByCityAndArea);
        System.out.println("ArrayList<House> realEstate: " + realEstate);

    }
}
