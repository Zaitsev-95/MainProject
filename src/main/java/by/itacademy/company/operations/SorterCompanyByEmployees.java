package by.itacademy.company.operations;

import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

public class SorterCompanyByEmployees extends StartBaseMenuItem implements MenuItem {
    public SorterCompanyByEmployees(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        fileReader.read().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public String name() {
        return "сортировки по колличеству сотрудников(отсортированно по умолчанию)";
    }

    protected void baseExecute() {
    }
}