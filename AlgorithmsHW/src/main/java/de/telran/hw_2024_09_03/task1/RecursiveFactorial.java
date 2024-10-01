package de.telran.hw_2024_09_03.task1;

public class RecursiveFactorial {
    public static long recursiveFactorial(long base){
        if (base < 1)
            return 1;
        long factorial = base - 1;
        return base * recursiveFactorial(factorial);
    }

}
