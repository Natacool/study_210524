package de.telran.hw_2024_08_30.task1;

public class Wall {
    String material;

    public Wall(WallEnum material) {
        switch (material){
            case BRICK:
                this.material = "bricks";
                break;
            case WOOD:
                this.material = "woods";
                break;
            case STONE:
                this.material = "stones";
                break;
            default:
                this.material = "unknown material";
        }
        System.out.println("Walls are from " + material);
    }

}
