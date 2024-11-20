package de.telran.hw_2024_10_21.task1;

import de.telran.hw_2024_10_21.example.Store;

import java.util.List;

public class RobotPut  implements Runnable {
    private Table table;
    List<Integer> components;

    RobotPut(Table table, List<Integer> components){
        this.table = table;
        this.components = components;
    }
    public void run(){
        for (int i = 0; i < components.size(); i++) {
            try {
                table.put(components.get(i));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        table.setDoExit(true);
    }
}
