package de.telran.hw_2024_09_18.task1;

public class MainWarehouse {
    public static void main(String[] args) {
        Warehouse wh = new Warehouse();
        wh.checkTotalBricks();
        wh.getBricks(5);
        wh.addBricks(6);
        wh.checkTotalBricks();
        wh.getBricks(6);
        wh.checkTotalBricks();
        wh.getBricks(6);
        wh.checkTotalBricks();

        wh.addBricks(6);
        wh.addBricks(6);
        wh.addBricks(6);
        wh.checkTotalBricks();
        wh.getBricks(6);
        wh.getBricks(5);
        wh.getBricks(4);
        wh.getBricks(5);
        wh.getBricks(2);
        wh.checkTotalBricks();
    }
}
