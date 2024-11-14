package de.telran.hw_2024_10_16.task1;

import de.telran.hw_2024_10_14.task2.ThreadTask;

public class MainFindPrime {
    public static void main(String[] args) throws InterruptedException {
        int num = 3;
        System.out.println(Thread.currentThread().getName() + " will create " + num + "threads...");

        FindPrime[] dts = new FindPrime[3];
/*
        for (int i = 0; i < num; i++) {
            dts[i] = new FindPrime(2, 1000000);
            dts[i].setDaemon(true);
            dts[i].start();
            //Thread.sleep(100);
        }
*/
        dts[0] = new FindPrime(2, 700000);
        dts[0].setDaemon(true);
        dts[0].start();

        dts[1] = new FindPrime(700000, 900000);
        dts[1].setDaemon(true);
        dts[1].start();

        dts[2] = new FindPrime(900000, 1000000);
        dts[2].setDaemon(true);
        dts[2].start();


        System.out.println("Main thread sleep 5 sec");
        Thread.sleep(5000);
        System.out.println("Interrupt: " + dts[0].getName());
        dts[0].interrupt();

        System.out.println("Main thread sleep 10 sec");
        Thread.sleep(10000);
        System.out.println("Interrupt: " + dts[1].getName());
        dts[1].interrupt();

        System.out.println("Main thread sleep 15 sec");
        Thread.sleep(15000);
        System.out.println("Interrupt: " + dts[2].getName());
        dts[2].interrupt();

        System.out.println("Main thread "
                + Thread.currentThread().getName()
                + " is exiting...");

    }
}
