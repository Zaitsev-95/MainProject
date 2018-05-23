package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StatistEmployeeData extends StartBaseMenuItem implements MenuItem {
    public StatistEmployeeData(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        Set<Company> companyList = fileReader.read();
        System.out.printf("Медина количества сотрудеников: %d \n",calculationMedina(companyList));
    }

    protected int calculationMedina(Set<Company> companyList) {
        int sum = 0;
        int d = companyList.size() / 2;
        List<Company> companies = new ArrayList<>();
        for (Company company : companyList) {
            companies.add(company);
        }
        if (companies.size() % 2 == 0) {
            int halfOne = companies.get(d).getPersonal();
            int halfTwo = companies.get(d - 1).getPersonal();
            int medina = (halfOne + halfTwo) / 2;
            return medina;
        } else {
            return companies.get(d).getPersonal();
        }
    }


    protected void baseExecute() {
    }

    @Override
    public String name() {
        return "вывода медианы количества сотрудников компаний";
    }
}