package de.telran.hw_2024_09_17.task1;

import java.util.Arrays;

// example from class but change to Descending order
public class MainMergeSortDescending {
    public static void main(String args[]) {
        /*
        mergeSortDescending(arr) - method that sorts arr[] using merge() in Descending order
        merge(arr, leftArr, rightArr) - merge two suarrays of arr[]
         */

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Initial array: " + Arrays.toString(arr));
        mergeSortDescending(arr);
        System.out.println("Result of Merge Sort in Descending order: " + Arrays.toString(arr));
    }

    private static void mergeSortDescending(int[] arr) {
        int lengthArr = arr.length; // длинна массивы
        if(lengthArr == 1) { // условие выхода
            return;
        }

        int mid = (lengthArr % 2 != 0) ? lengthArr/2 + 1 : lengthArr/2; //левый подмассив хочу больше, когда не парный размер
        int[] leftArr = new int[mid]; // левый подмассив
        int[] rightArr = new int[lengthArr - mid]; // правый подмассив

        // копируем элементы из массива в подмассивы
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int j = 0; j < lengthArr - mid; j++) {
            rightArr[j] = arr[j + mid];
        }
        System.out.println(Arrays.toString(leftArr)+" == "+Arrays.toString(rightArr));

        mergeSortDescending(leftArr);
        mergeSortDescending(rightArr);

        // когда мы достигли базового условия
        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        // контролируем индексы подмассивов
        int leftIndex = 0;
        int rightIndex = 0;

        // контролируем индекс в основном массиве
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex] > rightArr[rightIndex]) { // сравниваем элемент в левом и правом подмассиве
                arr[arrIndex] = leftArr[leftIndex]; // если условие верно, то элемент в левом меньше, сохраняем его
                // в 0 ячейку основного массива
                leftIndex++;
                arrIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
                arrIndex++;
            }
        }

        // копируем элементы если остались из левого
        while (leftIndex < leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        // копируем элементы из правого
        while (rightIndex < rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }

        System.out.println(Arrays.toString(leftArr)+" = "+Arrays.toString(rightArr)+" ===> "+Arrays.toString(arr));
    }
}
