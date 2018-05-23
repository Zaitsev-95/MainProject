package by.itacademy.company.items;

import by.itacademy.company.Company.Data;


public abstract class BaseMenuItem implements MenuItem, NameMenuItem {
    private final Data data;

    protected BaseMenuItem(Data data) {
        this.data = data;
    }

    public abstract String name();

    protected Data data() {
        return data;
    }
}