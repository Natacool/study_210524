package de.telran.hw_2024_08_28.task2;

public abstract class PostItem {
    String title;
    String senderAddress;
    String deliverAddress;

    abstract void deliver();
    abstract void send();

    public PostItem(String title, String senderAddress, String deliverAddress) {
        this.title = title;
        this.senderAddress = senderAddress;
        this.deliverAddress = deliverAddress;
    }
}
