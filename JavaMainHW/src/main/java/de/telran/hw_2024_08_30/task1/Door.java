package de.telran.hw_2024_08_30.task1;

public class Door {
    String material;

    public Door(DoorEnum material) {
        switch (material){
            case PLASTIC:
                this.material = "plastic";
                break;
            case WOOD:
                this.material = "wood";
                break;
            case IRON:
                this.material = "iron";
                break;
            default:
                this.material = "unknown material";
        }
        System.out.println("Door made from " + material);
    }

}
