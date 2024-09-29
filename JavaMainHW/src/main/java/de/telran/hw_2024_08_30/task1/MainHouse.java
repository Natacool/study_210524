package de.telran.hw_2024_08_30.task1;

public class MainHouse {
    public static void main(String[] args) {
        HouseResident resid1 = new HouseResident("Sebastian","Male", 36);
        HouseResident resid2 = new HouseResident("Brigitta","Female", 28);
        HouseResident resid3 = new HouseResident("Paul","Male", 44);
        HouseResident resid4 = new HouseResident("Margo","Female", 32);

        WallEnum walls1  = WallEnum.WOOD;
        WallEnum walls2  = WallEnum.BRICK;
        WallEnum walls3  = WallEnum.STONE;

        RoofEnum roof1  = RoofEnum.TRIANGLE;
        RoofEnum roof2  = RoofEnum.FLAT;
        RoofEnum roof3  = RoofEnum.SLOPING;

        DoorEnum door1  = DoorEnum.WOOD;
        DoorEnum door2  = DoorEnum.IRON;
        DoorEnum door3  = DoorEnum.IRON;

        WindowEnum windows1  = WindowEnum.PLASTIC;
        WindowEnum windows2  = WindowEnum.WOOD;
        WindowEnum windows3  = WindowEnum.WOOD;

        House house1 = new House(walls1, roof1, door1, windows1, resid1);
        house1.ChangeHouseResident(resid4);
        House house2 = new House(walls2, roof2, door2, windows2,resid2);
        House house3 = new House(walls2, roof2, door2, windows2);
        house3.ChangeHouseResident(resid3);
    }
}
