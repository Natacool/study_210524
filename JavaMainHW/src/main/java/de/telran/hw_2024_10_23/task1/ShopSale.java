package de.telran.hw_2024_10_23.task1;

import java.util.concurrent.Semaphore;

public class ShopSale implements Runnable
{
    private Semaphore semaphore;
    private int customer;
    private int serviceTime;
    public ShopSale(Semaphore semaphore, int customer, int serviceTime) {
        this.semaphore = semaphore;
        this.customer = customer;
        this.serviceTime = serviceTime;
    }
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("--> "
                    + Thread.currentThread().getName()
                    + " entered in to the shop");
            Thread.sleep(serviceTime);
            System.out.println("<-- \t\t\t"
                    +Thread.currentThread().getName()
                    + " has paid and left the shop");
            semaphore.release();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

}
