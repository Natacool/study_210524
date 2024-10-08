package de.telran.hw_2024_09_06.task2;

import java.util.Arrays;

public class MainIntArrayDim2 {
    public static void main(String[] args) {
        int[][] arr2 = {{1,2,3},{4,5,6},{3,9,2},{0,1,6}};
        System.out.println(Arrays.deepToString(arr2));

        int sumSquares=0;
        int sumAll=0;
        int min = arr2[0][0];
        int max1 = arr2[0][0];
        int max2 = arr2[0][0];
        for (int i=0; i< arr2.length; i++) {
            for (int j=0; j< arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " "); // вывод каждого
                sumSquares = sumSquares + arr2[i][j] * arr2[i][j]; // сумма квадратов
                sumAll = sumAll + arr2[i][j]; // сумма всех элементов
                if (arr2[i][j] < min) min = arr2[i][j]; // поиск минимального
                if (arr2[i][j] > max1) {
                    max2 = max1;
                    max1 = arr2[i][j];
                } else if (arr2[i][j] > max2) {
                    max2 = arr2[i][j];
                }
                if (arr2[i][j] % 2 == 0) {
                    arr2[i][j] = -1 * arr2[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Summa of all elements = " + sumAll);
        System.out.println("Minimum = " + min);
        System.out.println("Sum of squares = " + sumSquares);
        System.out.println("Second MAX = " + max2 + ", (max = " + max1 + ")");
        System.out.println("Array after exchange even the same negative:");
        System.out.println(Arrays.deepToString(arr2));
    }
}
