package de.telran.hw_2024_08_28.task2;

public class Package extends PostItem {

    public Package (String title, String senderAddress, String deliverAddress) {
        super(title, senderAddress, deliverAddress);
    }

    void deliver() {
        System.out.println("Deliver Package " + super.title + " using Car to " + super.deliverAddress);
    }

    void send()  {
        System.out.println("Send Package " + super.title + " using Car from " + super.senderAddress);
    }
}
