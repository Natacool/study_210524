package de.telran.onlineshop.dto;

public enum OrderStatusEnum {
    DRAFT("DRAFT"),
    ORDERED("ORDERED"),
    WAITFORPAYMENT("WAITFORPAYMENT"),
    PAID("PAID"),
    DELIVERING("Клиент"),
    DELIVERED("DELIVERED");

    private String title;

    private OrderStatusEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "OrderStatusEnum{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
