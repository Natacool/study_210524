package de.telran.hw_2024_08_28.task2;

public class Letter extends PostItem {

    public Letter (String title, String senderAddress, String deliverAddress) {
        super(title, senderAddress, deliverAddress);
    }

    void deliver() {
        System.out.println("Deliver Letter " + super.title + " using Foot to " + super.deliverAddress);
    }

    void send()  {
        System.out.println("Send Letter " + super.title + " using Foot from " + super.senderAddress);
    }

}
