package de.telran.hw_2024_08_28.task2;

public class MainPost {
    public static void main(String[] args) {

        PostItem mail1 = new Letter("Mail1", "Bonn", "Berlin");
        mail1.send();
        mail1.deliver();
        System.out.println("--------------------------------------------------------------");
        PostItem mail2 = new Letter("Mail2", "Berlin", "Munich");
        mail2.send();
        mail2.deliver();
        System.out.println("**************************************************************");

        PostItem parcel1 = new Parcel("Parcel1", "Hanover", "Oslo");
        parcel1.send();
        parcel1.deliver();
        System.out.println("--------------------------------------------------------------");
        PostItem parcel2 = new Parcel("Parcel2", "Paris", "Barcelona");
        parcel2.send();
        parcel2.deliver();
        System.out.println("**************************************************************");

        PostItem package1 = new Package("Package1", "Dresden", "Rostok");
        package1.send();
        package1.deliver();
        System.out.println("--------------------------------------------------------------");
        PostItem package2 = new Package("Package2", "Peking", "Nurnberg");
        package2.send();
        package2.deliver();
        System.out.println("**************************************************************");

        PostItem container1 = new Container("Container1", "Frankfurt", "Miami");
        container1.send();
        container1.deliver();
        System.out.println("--------------------------------------------------------------");
        PostItem container2 = new Container("Container2", "Bern", "London");
        container2.send();
        container2.deliver();
        System.out.println("**************************************************************");


    }
}
