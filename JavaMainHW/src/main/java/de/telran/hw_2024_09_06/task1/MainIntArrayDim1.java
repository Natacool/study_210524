package de.telran.hw_2024_09_06.task1;

import java.util.Arrays;

public class MainIntArrayDim1 {
    public static void main(String[] args) {
        int[] arr1 = {1,6,7,8,9,10,1,2,3,4,5,1};
        System.out.println(Arrays.toString(arr1));

        int sumSquares=0;
        int sumAll=0;
        int min = arr1[0];
        int max1 = arr1[0];
        int max2 = arr1[0];
        for (int i=0; i< arr1.length; i++) {
            System.out.print(arr1[i] + " "); // вывод каждого
            sumSquares = sumSquares + arr1[i]*arr1[i]; // сумма квадратов
            sumAll = sumAll + arr1[i]; // сумма всех элементов
            if (arr1[i] < min) min = arr1[i]; // поиск минимального
            if (arr1[i] > max1){
                max2 = max1;
                max1 = arr1[i];
            } else if (arr1[i] > max2) {
                max2 = arr1[i];
            }
            if (arr1[i]%2 == 0){
                arr1[i] = -1 * arr1[i];
            }
        }
        System.out.println();
        System.out.println("Summa of all elements = " + sumAll);
        System.out.println("Minimum = " + min);
        System.out.println("Sum of squares = " + sumSquares);
        System.out.println("Second MAX = " + max2 + ", (max = " + max1 + ")");
        System.out.println("Array after exchange even the same negative:");
        System.out.println(Arrays.toString(arr1));

    }
}
