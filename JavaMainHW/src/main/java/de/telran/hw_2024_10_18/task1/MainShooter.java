package de.telran.hw_2024_10_18.task1;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainShooter {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean isHit = new AtomicBoolean(false);
        Thread[] shooters = new Thread[5];
        for (int i = 0; i < 5; i++) {
            shooters[i] = new Thread(new Shooter(isHit), "Стрелок "+(i+1));
            shooters[i].start();
            Thread.sleep(50);
        }

        for (int i = 0; i < 5; i++) {
            shooters[i].join();
        }
    }
}

class Shooter implements Runnable {
    private AtomicBoolean isHit;

    public Shooter(AtomicBoolean isHit) {
        this.isHit = isHit;
    }

    @Override
    public void run() {
        Random random = new Random();

        // added reaction time to start shooting
        // this increases chance for 3/4/5 shooter
        int reaction = random.nextInt(5) + 1;
        try {
            Thread.sleep(reaction * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(!isHit.get()) {
            isHit.set(random.nextBoolean()); //выстрел
            System.out.println(Thread.currentThread().getName()+" его выстрел -> "+isHit.get());
        } else {
            System.out.println(Thread.currentThread().getName()+" не стреляет, т.к. мишень поражена");
        }
    }

}
