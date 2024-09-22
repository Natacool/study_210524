package de.telran.hw_2024_08_28.task2;

public class Parcel extends PostItem {

    public Parcel (String title, String senderAddress, String deliverAddress) {
        super(title, senderAddress, deliverAddress);
    }

    void deliver() {
        System.out.println("Deliver Parcel " + super.title + " using Motorcycle to " + super.deliverAddress);
    }

    void send()  {
        System.out.println("Send Parcel " + super.title + " using Motorcycle from " + super.senderAddress);
    }


}
