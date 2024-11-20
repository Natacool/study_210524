package de.telran.hw_2024_10_21.task1;

public class Table {
    private int component = 0;
    private boolean doExit = false;

    public boolean isDoExit() {
        return doExit;
    }

    public void setDoExit(boolean doExit) {
        this.doExit = doExit;
    }

    public synchronized void get() {
        while (component<1 && !doExit) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println("Robot: " + Thread.currentThread().getName()
                + " takes ("
                + component
                + ") component from the table.");
        component = 0;
        notify();
    }

    public synchronized void put(int component) {
        while (this.component > 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        this.component = component;
        System.out.println("Robot: " + Thread.currentThread().getName()
                + " puts ("
                + component
                + ") component on the table.");
        notify();
    }


}
