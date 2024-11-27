package de.telran.hw_2024_10_28.task1;

import java.time.LocalTime;

public class ScheduleTask  implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + "Connection to the site has established. Current time: "
                + LocalTime.now()
                );
    }
}
