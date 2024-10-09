package de.telran.hw_2024_09_10.task1;

import java.util.Arrays;

public class MainFibonacci {
    public static void main(String[] args) {
        int[] seqFib;
        seqFib = new int[11];
        System.out.println(Arrays.toString(seqFib));

        //  1  1  2  3  5  8  13  21  34  55  89
        findFibonacciIterative(11);

        // for recursive method - array should be initialised with 0
        // and length of array should be > 1
        seqFib =  findFibonacciRecursive(seqFib.length, seqFib);
        System.out.println(Arrays.toString(seqFib));

    }

    public static void findFibonacciIterative(int count) {
        int prev1 = 1;
        int prev2 = 1;
        System.out.print(prev1 + " ");

        for (int i = 3; i < count+1; i++){
            System.out.print(prev2 + " ");
            int tmp = prev2;
            prev2 = prev2 + prev1;
            prev1 = tmp;
        }
        System.out.println(prev2 + " ");
    }

    public static int[] findFibonacciRecursive(int count, int[] fib){
        if (count < 3){
            fib[0] = 1;
            if (fib.length > 1)
                fib[1] = 1;
            return fib;
        }
        fib = findFibonacciRecursive(count-1, fib);
        fib[count-1] = fib[count-2]+fib[count-3];
        return fib;
    }

    public static int[] findFibonacciDivideAndConquer(){
        System.out.println("Not implemented.");
        return null;
    }
}
