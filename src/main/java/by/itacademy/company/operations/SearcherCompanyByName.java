package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Exception.SearchCompanyException;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.Scanner;
import java.util.Set;

public class SearcherCompanyByName extends StartBaseMenuItem implements MenuItem {
    public SearcherCompanyByName(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        int counter = 0;
        FileReader fileReader = new FileReaderXml();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название компании(к примеру:HQSoftware, A1QA)");
        String search = scanner.nextLine();
        Set<Company> companyList = fileReader.read();
        String nameCompany;
        for (Company companys : companyList) {
            counter++;
            nameCompany = companys.getName();
            if (nameCompany.equals(search)) {
                System.out.println();
                System.out.println(companys);
                break;
            } else if ((nameCompany.equals(search) == false) && (companyList.size() == counter)) {
                try {
                    throw new SearchCompanyException();
                } catch (SearchCompanyException e) {
                    System.err.println("Введены не верные данные!\n");
                }
            }
        }
        System.out.println();
    }

    protected void baseExecute() {
    }

    @Override
    public String name() {
        return "поиска по названию компании";
    }
}