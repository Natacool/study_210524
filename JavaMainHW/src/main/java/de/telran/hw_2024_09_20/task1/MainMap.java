package de.telran.hw_2024_09_20.task1;

import java.util.*;

public class MainMap {
    public static void main(String[] args) {
        Map<String,Integer> towns = new HashMap<>();
        towns.put("Hamburg", 1900000);
        towns.put("Berlin", 3900000);
        towns.put("Munich", 1400000);
        towns.put("Frankfurt", 730000);
        towns.put("Cologne", 1000000);
        towns.put("Stuttgart", 600000);
        towns.put("Bonn", 330000);
        towns.put("Leipzig", 550000);
        towns.put("Dresden", 550000);
        towns.put("Dusseldorf", 600000);
        towns.put("Bremen", 550000);
        towns.put("Koblenz", 110000);
        towns.put("Potsdam", 160000);
        towns.put("Hanover", 550000);
        towns.put("Erfurt", 200000);
        towns.put("Rostock", 200000);
        towns.put("Jena", 110000);
        towns.put("Dortmund", 600000);
        towns.put("Essen", 600000);
        System.out.println(towns);

        // Найдите город с самым большим количеством жителей.
        Collection<Integer> listValues = towns.values();
        int max = listValues
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .toList().get(0);

        Iterator<Map.Entry<String,Integer>> itMap = towns.entrySet().iterator();
        while (itMap.hasNext()) {
            Map.Entry<String, Integer> entry = itMap.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == max) {
                System.out.println("Town with max population: " + key);
                //System.out.println(key + " -> " + value);
            }
        }

        //Найдите среднее количество жителей по всем городам.
        long allPopulation = 0;
        for (Map.Entry<String, Integer> entry : towns.entrySet()) {
            allPopulation = allPopulation + entry.getValue();
            //System.out.println(entry.getKey()+" -> "+entry.getValue()/*+ " ==> "+entry.getClass()*/);
        }
        if (listValues.size() != 0)
            System.out.println("Average population in a town: "
                    + allPopulation/listValues.size());
        else
            System.out.println("No population in all towns");


        //Найдите все города, у которых количество жителей одинаковое.
        Map<Integer, ArrayList<String>> samePopulation = new HashMap<>();
        for (Map.Entry<String, Integer> entry : towns.entrySet()) {
            //System.out.println(entry.getKey()+" -> "+entry.getValue()/*+ " ==> "+entry.getClass()*/);
            ArrayList<String> townsList = samePopulation.get(entry.getValue());
            if (townsList == null) townsList = new ArrayList<>();
            //System.out.println("townsList1: " + townsList);
            townsList.add(entry.getKey());
            //System.out.println("townsList2: " + townsList);
            samePopulation.put(entry.getValue(),townsList);
            //System.out.println(entry.getKey()+" -> "+entry.getValue()/*+ " ==> "+entry.getClass()*/);
        }
        //System.out.println(samePopulation);
        System.out.println("Towns with the same population: ");
        ArrayList<String> same;
        for (Map.Entry<Integer, ArrayList<String>> entry : samePopulation.entrySet()) {
            if (entry.getValue().size() > 1){
                System.out.println("Towns: " + entry.getValue()
                        + ", population: " + entry.getKey());
            }
        }



    }
}
