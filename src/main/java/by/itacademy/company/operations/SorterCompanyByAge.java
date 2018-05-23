package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.*;

public class SorterCompanyByAge extends StartBaseMenuItem implements MenuItem {
    List<Company> result = new LinkedList<>();

    public SorterCompanyByAge(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        data().list().addAll(fileReader.read());
        for (Company company : data().list()) {
            result.add(company);
        }
        result.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public String name() {
        return "сортировки по дате регистрации компании";
    }

    protected void baseExecute() {
    }
}