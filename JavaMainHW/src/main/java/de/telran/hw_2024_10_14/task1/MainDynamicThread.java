package de.telran.hw_2024_10_14.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDynamicThread {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of threads: ");
        int num = scanner.nextInt();
        System.out.println("Will be created " + num + "threads...");

        DynamicThread[] dts = new DynamicThread[num];
        for (int i = 0; i < num; i++) {
            dts[i] = new DynamicThread(i);
        }

        for (int i = 0; i < num; i++) {
            dts[i].start();
        }

        for (int i = 0; i < num; i++) {
            dts[i].join();
        }
        System.out.println("Main thread is exiting...");

    }
}
