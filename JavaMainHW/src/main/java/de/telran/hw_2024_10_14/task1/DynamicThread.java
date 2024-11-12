package de.telran.hw_2024_10_14.task1;

public class DynamicThread extends Thread{
    private int tId;

    public DynamicThread(int id) {
        this.tId = id;
    }

    public int getTid() {
        return tId;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println("Thread ID = "
                        + this.tId
                        + ", run ("
                        + i
                        + ") time"
                        + ", thread name: "
                        + Thread.currentThread().getName()
                );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
