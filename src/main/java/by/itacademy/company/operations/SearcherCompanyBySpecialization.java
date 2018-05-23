package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SearcherCompanyBySpecialization extends StartBaseMenuItem implements MenuItem {

    public SearcherCompanyBySpecialization(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите специализацию(к примеру:Gamedev, Machine learning)");
        String search = scanner.nextLine();
        Set<Company> companyList = fileReader.read();
        String nameCompany;
        for (Company companys : companyList) {
            List<String> sd = companys.getSpecialization();
            for (String spec : sd) {
                if (spec.equals(search)) {
                    System.out.println(companys);
                }
            }
        }
        System.out.println();
    }

    protected void baseExecute() {
    }

    @Override
    public String name() {
        return "поиска по специализации компании";
    }
}