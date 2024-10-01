package de.telran.hw_2024_09_03.task1;

public class IterativeFactorial {
    public static long iterativeFactorial(long n){
        long factorial = 1;
        long base = n;
        while(base > 0){
            factorial = factorial * base;
            base = base - 1;
        }
        return factorial;
    }
}
