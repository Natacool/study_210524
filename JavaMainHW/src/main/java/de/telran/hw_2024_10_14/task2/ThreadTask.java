package de.telran.hw_2024_10_14.task2;

public class ThreadTask  extends Thread {
    private int start;
    private int end;
    private int div;
    public long sum;

    public ThreadTask(int start, int end, int div) {
        this.start = start;
        this.end = end;
        this.div = div;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if(i % div == 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName()
                        + " -> amount = "
                        + sum);
            }
        }
    }
}
