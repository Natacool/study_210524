package de.telran.hw_2024_08_19.task2;

public class MainPhone {

    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.number = "+49-123-456-7890";
        phone1.weight = 225;
        phone1.model = "Samsung S22";

        Phone phone2 = new Phone();
        phone2.number = "+49-456-789-0123";
        phone2.weight = 144;
        phone2.model = "Motorola Razor";

        Phone phone3 = new Phone();
        phone3.number = "+49-987-654-0123";
        phone3.weight = 312;
        phone3.model = "LG G5";

        phone1.receiveCall("John Smith");
        System.out.println( "phone1 number: " + phone1.getNumber());

        phone2.receiveCall("Anna Brown");
        System.out.println( "phone2 number: " + phone2.getNumber());

        phone3.receiveCall("Margareth Lee");
        System.out.println( "phone3 number: " + phone3.getNumber());
    }
}
