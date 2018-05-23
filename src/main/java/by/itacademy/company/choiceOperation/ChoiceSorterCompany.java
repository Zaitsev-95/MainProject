package by.itacademy.company.choiceOperation;

import by.itacademy.company.Company.Data;
import by.itacademy.company.items.BaseMenuItem;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;
import by.itacademy.company.items.impl.ExitMenuItem;
import by.itacademy.company.operations.SorterCompanyByAge;
import by.itacademy.company.operations.SorterCompanyByEmployees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChoiceSorterCompany extends StartBaseMenuItem implements MenuItem {
    private Data data = new Data();

    public ChoiceSorterCompany(Data data, MenuItem menuItem) {
        super(data, menuItem);
    }

    private Map<Integer, BaseMenuItem> items = new HashMap<>();

    {
        items.put(1, new SorterCompanyByEmployees(data, this));
        items.put(2, new SorterCompanyByAge(data, this));
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

    @Override
    public String name() {
        return "сортировки";
    }

    @Override
    protected void baseExecute() {
    }
}