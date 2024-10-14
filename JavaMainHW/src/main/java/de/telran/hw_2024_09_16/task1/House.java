package de.telran.hw_2024_09_16.task1;

public class House implements Comparable<House> {
    private String city; // город
    private int area; //площадь дома
    private int price; // цена
    private boolean hasFurniture; //продается с мебелью

    public House(String city, int area, int price, boolean hasFurniture) {
        this.city = city;
        this.area = area;
        this.price = price;
        this.hasFurniture = hasFurniture;
    }

    public String getCity() {
        return city;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    @Override
    public String toString() {
        return "House{" +
                "city=" + city +
                ", area=" + area +
                ", price=" + price +
                ", hasFurniture=" + hasFurniture +
                '}' + "\n";
    }

    // comparing by Price
    @Override
    public int compareTo(House house) {
        if (this.price < house.getPrice()) return 1;
        else if (this.price > house.getPrice())  return -1;
        else return 0;
    }
}
