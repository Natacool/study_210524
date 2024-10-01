package de.telran.hw_2024_09_03.task1;

import java.util.Scanner;

public class MainFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number to calculate factorial > ");
        long base = in.nextLong();
        System.out.println("IterativeFactorial(" + base + ") = "
                + IterativeFactorial.iterativeFactorial(base));

        System.out.println("RecursiveFactorial(" + base + ") = "
                + RecursiveFactorial.recursiveFactorial(base));

    }
}
