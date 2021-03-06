package by.itacademy.company.choiceOperation;

import by.itacademy.company.Company.Data;
import by.itacademy.company.items.BaseMenuItem;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;
import by.itacademy.company.items.impl.ExitMenuItem;
import by.itacademy.company.operations.StatistAgeData;
import by.itacademy.company.operations.StatistEmployeeData;
import by.itacademy.company.operations.StatistLocationData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChoiceStatistData extends StartBaseMenuItem implements MenuItem {
    private Data data = new Data();

    public ChoiceStatistData(Data data, MenuItem menuItem) {
        super(data, menuItem);
    }

    private Map<Integer, BaseMenuItem> items = new HashMap<>();

    {
        items.put(1, new StatistEmployeeData(data, this));
        items.put(2, new StatistAgeData(data, this));
        items.put(3, new StatistLocationData(data, this));
        items.put(4, new ExitMenuItem(data));
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
        if (d.matches("[1-4]")) {
            items.get(Integer.parseInt(d)).execute();
        } else {
            System.err.println("ввести неодходимо числа от 1 до 4!");
            execute();
        }
    }

    @Override
    protected void baseExecute() {
    }

    @Override
    public String name() {
        return "для вывода статистики по компаниям";
    }
}