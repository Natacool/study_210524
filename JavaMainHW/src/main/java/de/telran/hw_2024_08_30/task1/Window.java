package de.telran.hw_2024_08_30.task1;

public class Window {
    String material;

    public Window(WindowEnum material) {
        switch (material){
            case PLASTIC:
                this.material = "plastic";
                break;
            case WOOD:
                this.material = "wood";
                break;
            default:
                this.material = "unknown material";
        }
        System.out.println("Windows are from " + material);
    }
}
