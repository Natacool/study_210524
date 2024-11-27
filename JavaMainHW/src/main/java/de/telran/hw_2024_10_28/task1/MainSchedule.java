package de.telran.hw_2024_10_28.task1;

public class MainSchedule {
    public static void main(String[] args) throws InterruptedException {

        ScheduleTask task = new ScheduleTask();
        Schedule schedule = new Schedule(task);
        Thread sc = new Thread(schedule);
        sc.start();

        System.out.println("Main thread does smth ..." + Thread.currentThread().getName());
        Thread.sleep(3600000);
        System.out.println("Main thread has finished to do smth ..." + Thread.currentThread().getName());
        System.out.println("Main thread stops schedule" + Thread.currentThread().getName());
        schedule.stopSchedule();
    }
}
