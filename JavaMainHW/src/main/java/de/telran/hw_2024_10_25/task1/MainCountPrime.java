package de.telran.hw_2024_10_25.task1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainCountPrime {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountPrime calc1 = new CountPrime(1, 480000);
        CountPrime calc2 = new CountPrime(480001, 700000);
        CountPrime calc3 = new CountPrime(700001, 860000);
        CountPrime calc4 = new CountPrime(860001, 1000000);

        FutureTask<Long> future1 = new FutureTask<>(calc1);
        new Thread(future1).start();

        FutureTask<Long> future2 = new FutureTask<>(calc2);
        new Thread(future2).start();

        FutureTask<Long> future3 = new FutureTask<>(calc3);
        new Thread(future3).start();

        FutureTask<Long> future4 = new FutureTask<>(calc4);
        new Thread(future4).start();

        LocalTime startTime = LocalTime.now();
        System.out.println("Amount of primes in range {1, 1 000 000}: "
                + (future1.get()
                + future2.get()
                + future3.get()
                + future4.get())
        );
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(endTime, startTime);
        System.out.println("time: "
                + Math.abs(duration.toMinutesPart())
                + " minutes "
                + Math.abs(duration.toSecondsPart())
                + " seconds "
        );
    }
}
