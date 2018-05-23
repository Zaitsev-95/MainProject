package by.itacademy.company.items.impl;

import by.itacademy.company.Company.Data;
import by.itacademy.company.items.BaseMenuItem;
import by.itacademy.company.items.MenuItem;

public class ExitMenuItem extends BaseMenuItem implements MenuItem {
    public ExitMenuItem(Data data) {
        super(data);
    }

    @Override
    public void execute() {
    }

    @Override
    public String name() {
        return "Exit from program.";
    }
}