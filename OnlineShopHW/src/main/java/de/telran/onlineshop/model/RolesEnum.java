package de.telran.onlineshop.model;

public enum RolesEnum {
    CLIENT("Клиент"),
    ADMINISTRATOR("Администратор");

    private String title;

    private RolesEnum(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RolesEnum{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
