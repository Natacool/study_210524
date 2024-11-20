package de.telran.hw_2024_10_22.task1;

public class Task {
    private String name;
    private int time;
    private int cost;

    public Task(String name, int time, int cost) {
        this.name = name;
        this.time = time;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", cost=" + cost +
                '}';
    }
}
