package de.telran.hw_2024_10_15.task3;

public class Node2Way {
    private int data;
    private Node2Way next;
    private Node2Way prev;

    public Node2Way(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node2Way getNext() {
        return next;
    }

    public void setNext(Node2Way next) {
        this.next = next;
    }

    public Node2Way getPrev(){
        return prev;
    }

    public void setPrev(Node2Way prev) {
        this.prev = prev;
    }
}
