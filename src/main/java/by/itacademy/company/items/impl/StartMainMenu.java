package by.itacademy.company.items.impl;

import by.itacademy.company.Company.Data;
import by.itacademy.company.items.BaseMenuItem;
import by.itacademy.company.items.MenuItem;

import java.util.*;
public class StartMainMenu implements MenuItem {
    private Data data = new Data();
    private Map<Integer, BaseMenuItem> items = new HashMap<>();

    {
        items.put(1, new ChoiceXml(data, this));
        items.put(2, new ChoiceJson(data, this));
        items.put(3, new ExitMenuItem(data));
    }

    @Override
    public void execute() {
        for (Map.Entry<Integer, BaseMenuItem> entry : items.entrySet()) {
            System.out.println("Введите " + entry.getKey() + " для " + entry.getValue().name());
        }
        adoption();
    }

    private void adoption() {
        Scanner scanner = new Scanner(System.in);
        String d = scanner.nextLine();
        if (d.matches("[1-3]")) {
            items.get(Integer.parseInt(d)).execute();
        } else {
            System.err.println("ввести неодходимо числа от 1 до 3!");
            execute();
        }
    }
}