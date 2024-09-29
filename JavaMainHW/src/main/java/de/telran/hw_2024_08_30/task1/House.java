package de.telran.hw_2024_08_30.task1;

public class House {
    Door door;
    Roof roof;
    Wall walls;
    Window windows;
    HouseResident resident;

    public House(WallEnum walls, RoofEnum roof,
            DoorEnum door, WindowEnum windows,
            HouseResident resident) {
        System.out.println("-----------------------------------------");
        System.out.println("This a new house.");
        this.door = new Door(door);
        this.roof = new Roof(roof);
        this.walls = new Wall(walls);
        this.windows = new Window(windows);
        this.resident = resident;
        System.out.println("Hi I am new resident, my name is " + resident.name);
    }

    public House(WallEnum walls, RoofEnum roof,
                 DoorEnum door, WindowEnum windows) {
        System.out.println("-----------------------------------------");
        System.out.println("This a new house.");
        this.door = new Door(door);
        this.roof = new Roof(roof);
        this.walls = new Wall(walls);
        this.windows = new Window(windows);
        System.out.println("This house is empty. No residents there.");
    }
    public void ChangeHouseResident(HouseResident resident){
        String oldResident = " ...";
        System.out.println("Hi I am new resident, my name is " + resident.name);

        if (this.resident != null) oldResident = this.resident.name;
        System.out.println("I replaced " + oldResident);

        this.resident = resident;
    }
}
