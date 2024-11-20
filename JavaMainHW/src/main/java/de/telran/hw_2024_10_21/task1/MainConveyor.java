package de.telran.hw_2024_10_21.task1;

import java.util.Arrays;
import java.util.List;

public class MainConveyor {
    public static void main(String[] args) {
        List<Integer> components = Arrays.asList(11, 12, 13, 14, 15, 6, 7, 8, 9, 10);

        Table table = new Table();
        RobotGet robotGet = new RobotGet(table);
        new Thread(robotGet).start();

        RobotPut robotPut = new RobotPut(table, components);
        new Thread(robotPut).start();

    }
}
