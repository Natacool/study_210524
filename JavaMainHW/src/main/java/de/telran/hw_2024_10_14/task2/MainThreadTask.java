package de.telran.hw_2024_10_14.task2;

import de.telran.hw_2024_10_14.task1.DynamicThread;


public class MainThreadTask {
    public static void main(String[] args) throws InterruptedException {
        int num = 3;
        System.out.println(Thread.currentThread().getName() + " will create " + num + "threads...");

        ThreadTask[] dts = new ThreadTask[3];
        for (int i = 0; i < num; i++) {
            dts[i] = new ThreadTask(0, 10000000, 17);
            dts[i].setDaemon(true);
            dts[i].start();
        }

        System.out.println("Main thread sleep 1 sec");
        Thread.sleep(100);
        System.out.println("Main thread "
                + Thread.currentThread().getName()
                + " is exiting...");
    }
}
