package de.telran.hw_2024_10_21.task1;

import de.telran.hw_2024_10_21.example.Store;

public class RobotGet  implements Runnable {
    private Table table;
    RobotGet(Table table){
        this.table = table;
    }
    public void run(){
        while (!table.isDoExit()){
            table.get(); // забирать товар
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
