package de.telran.hw_2024_10_28.task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedule implements Runnable {
    private ScheduleTask scheduleTask;
    private ScheduledExecutorService executorService;

    public Schedule(ScheduleTask scheduleTask) {
        this.scheduleTask = scheduleTask;
    }

    public void stopSchedule()
    {
        executorService.shutdown();
    }

    @Override
    public void run() {
        System.out.println("Start checking site ..." + Thread.currentThread().getName());
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this.scheduleTask, 0, 65, TimeUnit.SECONDS);
    }
}
