package de.telran.hw_2024_08_28.task2;

public class Container extends PostItem {

    public Container (String title, String senderAddress, String deliverAddress) {
        super(title, senderAddress, deliverAddress);
    }

    void deliver() {
        System.out.println("Deliver Container " + super.title + " using Truck to " + super.deliverAddress);
    }

    void send()  {
        System.out.println("Send Container " + super.title + " using Truck from " + super.senderAddress);
    }

}
