package by.itacademy.company.items.impl;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.choiceOperation.ChoiceSercherCompany;
import by.itacademy.company.choiceOperation.ChoiceSorterCompany;
import by.itacademy.company.choiceOperation.ChoiceStatistData;
import by.itacademy.company.items.BaseMenuItem;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.*;

public class ChoiceXml extends StartBaseMenuItem implements MenuItem {
    private Data data = new Data();

    public ChoiceXml(Data data, MenuItem menuItem) {
        super(data, menuItem);
    }

    private Map<Integer, BaseMenuItem> items = new HashMap<>();

    {
        items.put(1, new ChoiceSorterCompany(data, this));
        items.put(2, new ChoiceSercherCompany(data, this));
        items.put(3, new ChoiceStatistData(data, this));
        items.put(4, new ExitMenuItem(data));
    }

    @Override
    protected void baseExecute() {
        for (Map.Entry<Integer, BaseMenuItem> entry : items.entrySet()) {
            System.out.println("Введите " + entry.getKey() + " для " + entry.getValue().name());
        }
        adoption();
        FileReader fileReader = new FileReaderXml();

        for (Company company :
                fileReader.read()) {

            data.addCompanyInData(company);
        }
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
    public String name() {
        return "для работы с форматом Xml";
    }
}