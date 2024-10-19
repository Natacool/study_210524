package de.telran.hw_2024_09_20.task2;

import java.util.*;

public class MainCat {
    public static void main(String[] args) {
        Map<String, Cat> cats  = new TreeMap<>();
        Cat cat01 = new Cat("Cat20",3, 2, "Syam");
        cats.put(cat01.getName(), cat01);
        Cat cat02 = new Cat("Cat19",4,2, "British");
        cats.put(cat02.getName(), cat02);
        Cat cat03 = new Cat("Cat18",6,3, "Persian");
        cats.put(cat03.getName(), cat03);
        Cat cat04 = new Cat("Cat17",9,2, "Sphynx");
        cats.put(cat04.getName(), cat04);
        Cat cat05 = new Cat("Cat15",3,3, "Scottish");
        cats.put(cat05.getName(), cat05);
        Cat cat06 = new Cat("Cat16",4,3, "Russian Blue");
        cats.put(cat06.getName(), cat06);
        Cat cat07 = new Cat("Cat14",5,2, "Syam");
        cats.put(cat07.getName(), cat07);
        Cat cat08 = new Cat("Cat13",6,3, "Syam");
        cats.put(cat08.getName(), cat08);
        Cat cat09 = new Cat("Cat10",5,3, "British");
        cats.put(cat09.getName(), cat09);
        Cat cat10 = new Cat("Cat11",4,4, "Persian");
        cats.put(cat10.getName(), cat10);
        Cat cat11 = new Cat("Cat12",3,3, "Syam");
        cats.put(cat11.getName(), cat11);
        Cat cat12 = new Cat("Cat09",4,2, "British");
        cats.put(cat12.getName(), cat12);
        Cat cat13 = new Cat("Cat08",3,3, "Persian");
        cats.put(cat13.getName(), cat13);
        Cat cat14 = new Cat("Cat07",5,2, "Sphynx");
        cats.put(cat14.getName(), cat14);
        Cat cat15 = new Cat("Cat05",5,4, "Scottish");
        cats.put(cat15.getName(), cat15);
        Cat cat16 = new Cat("Cat06",2,2, "Russian Blue");
        cats.put(cat16.getName(), cat16);
        Cat cat17 = new Cat("Cat04",5,3, "Syam");
        cats.put(cat17.getName(), cat17);
        Cat cat18 = new Cat("Cat03",4,4, "Syam");
        cats.put(cat18.getName(), cat18);
        Cat cat19 = new Cat("Cat02",4,3, "British");
        cats.put(cat19.getName(), cat19);
        Cat cat20 = new Cat("Cat01",3,2, "Persian");
        cats.put(cat20.getName(), cat20);

        System.out.println(cats);

        for (Map.Entry<String, Cat> cat : cats.entrySet()) {
            if (cat.getValue().getBreed() == "British") {
                System.out.println(cat.getValue().getName() + ", breed: "
                        + cat.getValue().getBreed());
            }
        }

        for (Map.Entry<String, Cat> cat : cats.entrySet()) {
            if (cat.getValue().getWeight() > 3) {
                System.out.println(cat.getValue().getName() + ", weight > 3: "
                        + cat.getValue().getWeight());
            }
        }

    }
}
