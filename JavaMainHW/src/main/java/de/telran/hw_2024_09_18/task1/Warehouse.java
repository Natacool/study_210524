package de.telran.hw_2024_09_18.task1;

import java.util.Stack;

public class Warehouse {
    private final int max_amount = 17;
    private int totalBricks;
    private Stack<Integer> bricksBlocks;

    public Warehouse() {
        this.bricksBlocks = new Stack<>();
        this.totalBricks = 0;
    }

    public void addBricks(int bricksBlocks){
        int tempBricksBlocks = bricksBlocks;

        if ((this.totalBricks + tempBricksBlocks) > this.max_amount){
            tempBricksBlocks = this.max_amount - this.totalBricks;
        }
        this.totalBricks = this.totalBricks + tempBricksBlocks;
        System.out.println("Added "
                + tempBricksBlocks  + " blocks of bricks! Wanted to add: "
                + bricksBlocks
                +". Rest: "
                + this.totalBricks
                + ". (Maximum: " + this.max_amount + ").");
        this.bricksBlocks.push(tempBricksBlocks);
    }

    public int getBricks(int reqBricksBlocks) {
        int realBricks = 0;
        if (bricksBlocks.empty()){
            System.out.print("No bricks in the warehouse! ");
        }
        else {
            while (!bricksBlocks.empty()){
                int tempBricksBlocks = bricksBlocks.pop();
                realBricks = realBricks + tempBricksBlocks;

                if (realBricks == reqBricksBlocks){
                    break;
                }
                else if (realBricks > reqBricksBlocks) {
                    tempBricksBlocks = realBricks - reqBricksBlocks;
                    bricksBlocks.push(tempBricksBlocks); // add rest back
                    realBricks = reqBricksBlocks;
                    break;
                }
            }
            this.totalBricks = this.totalBricks - realBricks;
            if (realBricks < reqBricksBlocks){
                System.out.print("Not enough bricks! ");
            }
        }
        System.out.println("You will get "
                + realBricks  + " blocks of bricks! Requested: "
                + reqBricksBlocks
                + ". Rest: "
                + this.totalBricks);
        return realBricks;
    }

    public void checkTotalBricks(){
        System.out.println("Available " + this.totalBricks + " blocks of bricks!");
    }
}
