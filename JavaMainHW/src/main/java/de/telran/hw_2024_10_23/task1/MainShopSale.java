package de.telran.hw_2024_10_23.task1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Semaphore;

public class MainShopSale {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10000];
        // Ограничить количество одновременно работающих потоков
        Semaphore semaphore = new Semaphore(10, true); //fair - не всегда срабатывает

        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ShopSale(semaphore, i, 30000), "Customer - "+i); // service time in ms for sleep
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(endTime, startTime);
        System.out.println("The shop has served 10 000 customers in "
                + Math.abs(duration.toHoursPart()) + " hours "
                + Math.abs(duration.toMinutesPart()) + " minutes "
                + Math.abs(duration.toSecondsPart()) + " seconds.");
    }

}

