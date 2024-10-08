package de.telran.hw_2024_09_09.task1;

import java.util.*;

public class MainListIterator {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        listA.addAll(List.of(1,2,3,4,5,6,22,8,9));
//        listA.addAll(List.of(1,2,3,2,1));

        System.out.println("Initial ArrayList");
        System.out.println(listA);

        int sum2 = 0;
        int size = listA.size();
        int min = listA.get(0);
        int max1 = listA.get(0);
        int max2 = listA.get(0);
        double avgSum = 0;
        Iterator<Integer> iterator = listA.iterator();
        while (iterator.hasNext()) {
            Integer el = iterator.next();
            sum2 = sum2 + el*el;  // сумма квадратов
            avgSum = avgSum + el; // сумма всех элементов для вычисления среднего
            if (el < min) min = el; // поиск минимального
            // поиск двух наибольших - надо второй по величине
            if (el > max1){
                max2 = max1;
                max1 = el;
            } else if (el > max2) {
                max2 = el;
            }

            if (el % 2 == 0) iterator.remove(); // удалить четные
        }
        System.out.println("Average = " + avgSum);
        System.out.println("Average = " + avgSum/size);
        System.out.println("Minimum = " + min);
        System.out.println("Sum of squares = " + sum2);
        System.out.println("Second MAX = " + max2 + ", (max = " + max1 + ")");
        System.out.println("List after remove all even numbers:");
        System.out.println(listA);
        System.out.println("*****************************************");

        List<Integer> listL = new LinkedList<>();
        listL.addAll(List.of(1,2,3,4,5,6,22,8,9));
//        listL.addAll(List.of(1,2,3,2,1));
        System.out.println("Initial LinkedList");
        System.out.println(listL);

        ListIterator<Integer> listIterator = listL.listIterator(listL.size()); // конец списка

        int max = listL.get(0);
        int allMul = 1;

        while (listIterator.hasPrevious()) {
            Integer el = listIterator.previous();
            System.out.print(el + " "); // вывод в обратном порядке
            allMul = allMul * el; // произведение всех
            if (el > max) max = el; // поиск максимума
            if (el % 3 == 0){
                listIterator.set(0);  // обнуление делящихся на 3
            }
        }
        System.out.println();
        System.out.println("Maximum = " + max);
        System.out.println("Multiplication of all = " + allMul);
        System.out.println("List after remove all numbers divided by 3 without rest:");
        System.out.println(listL);

        // удаление дубликатов, но с сортировкой
        // - наверно можно использовать map для хранения пар
        // - key = значение из листа, value = индекс в листе
        System.out.println("*****************************************");
        listL = new LinkedList<>();
        System.out.println("Initial LinkedList for delete duplicates: ");
        listL.addAll(List.of(3,1,2,1,1,2,3,2,1));
        System.out.println(listL);
        listIterator = listL.listIterator();
        Set<Integer> setInt = new HashSet<>();
        while (listIterator.hasNext()) {
            Integer el = listIterator.next();
            setInt.add(el);
        }
        listL= setInt.stream().toList();
        System.out.println("List after removing duplicates:");
        System.out.println(listL);
    }
}
