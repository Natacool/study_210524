package de.telran.hw_2024_09_13.task1;

import java.util.*;

public class MainHuman {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<Human>();
        Human man1 = new Human("Ivan", "Blue", 13);
        Human man2 = new Human("Petr", "Grey", 16);
        Human man3 = new Human("Alisa", "Green", 23);
        Human man4 = new Human("Katia", "Blue", 33);
        Human man5 = new Human("Nina", "Brown", 31);
        Human man6 = new Human("Vasia", "Brown", 11);
        Human man7 = new Human("Tania", "Blue", 10);
        Human man8 = new Human("Margo", "Grey", 23);
        Human man9 = new Human("Marat", "Brown", 13);
        Human man0 = new Human("Ivan", "Blue", 13);
        humans.add(man1);
        humans.add(man2);
        humans.add(man3);
        humans.add(man4);
        humans.add(man5);
        humans.add(man6);
        humans.add(man7);
        humans.add(man8);
        humans.add(man9);
        humans.add(man0);

        // print all
        Iterator<Human> iterator = humans.iterator();
        while (iterator.hasNext()) {
            Human man = iterator.next();
            System.out.println(man);
        }

        // print only human with blue color eye
        System.out.println("-----------------------------------------------");
        iterator = humans.iterator();
        while (iterator.hasNext()) {
            Human man = iterator.next();
            if(man.getEye() == "Blue")
                System.out.println(man);
        }

        // print unique humans
        System.out.println("-----------------------------------------------");
        Map<Integer, Human> humanMap = new HashMap<Integer, Human>();
        iterator = humans.iterator();
        while (iterator.hasNext()) {
            Human man = iterator.next();
            String commonHumanData = man.getName() + man.getEye() + man.getAge();
            humanMap.put(commonHumanData.hashCode(), man);
        }
        System.out.println(humanMap); // only 1 Ivan should be

        // remove all where age < 16
        System.out.println("-----------------------------------------------");
        iterator = humans.iterator();
        while (iterator.hasNext()) {
            Human man = iterator.next();
            if(man.getAge() < 16)
                iterator.remove();
        }
        System.out.println(humans);
    }
}
