package de.telran.hw_2024_08_30.task1;

public class Roof {
    String type; // triangle, flat, sloping

    public Roof(RoofEnum type) {
        switch (type){
            case TRIANGLE:
                this.type = "triangle";
                break;
            case FLAT:
                this.type = "flat";
                break;
            case SLOPING:
                this.type = "sloping";
                break;
            default:
                this.type = "unknown";
        }
        System.out.println("Roof is " + type);
    }
}
