package de.telran.hw_2024_09_06.task3;

import java.util.Arrays;

public class MainIntArrayDim3 {
    public static void main(String[] args) {
        int[][][] arr3 = {{{1,2},{3,4}}, {{11,22},{33,44}}, {{111,222},{333,444}}};
        System.out.println(Arrays.deepToString(arr3));

        int sumSquares=0;
        int sumAll=0;
        int min = arr3[0][0][0];
        int max1 = arr3[0][0][0];
        int max2 = arr3[0][0][0];
        for (int i=0; i< arr3.length; i++) {
            for (int j=0; j< arr3[i].length; j++) {
                for (int k=0; k< arr3[i][j].length; k++) {
                    System.out.print(arr3[i][j][k] + " "); // вывод каждого
                    sumSquares = sumSquares + arr3[i][j][k] * arr3[i][j][k]; // сумма квадратов
                    sumAll = sumAll + arr3[i][j][k]; // сумма всех элементов
                    if (arr3[i][j][k] < min) min = arr3[i][j][k]; // поиск минимального
                    if (arr3[i][j][k] > max1) {
                        max2 = max1;
                        max1 = arr3[i][j][k];
                    } else if (arr3[i][j][k] > max2) {
                        max2 = arr3[i][j][k];
                    }
                    if (arr3[i][j][k] % 2 == 0) {
                        arr3[i][j][k] = -1 * arr3[i][j][k];
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Summa of all elements = " + sumAll);
        System.out.println("Minimum = " + min);
        System.out.println("Sum of squares = " + sumSquares);
        System.out.println("Second MAX = " + max2 + ", (max = " + max1 + ")");
        System.out.println("Array after exchange even the same negative:");
        System.out.println(Arrays.deepToString(arr3));
    }
}
