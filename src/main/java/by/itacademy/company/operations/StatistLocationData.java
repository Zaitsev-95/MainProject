package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.util.Set;

public class StatistLocationData extends StartBaseMenuItem implements MenuItem {
    public StatistLocationData(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        Set<Company> companyList = fileReader.read();
        int sum = 0;
        int d = companyList.size();
        int foreign = 0;
        int local = 0;
        for (Company companys : companyList) {
            int s = companyList.size();
            boolean quantityPersonal = companys.isForeign();
            if (quantityPersonal) {
                foreign++;
            } else {
                local++;
            }
            --d;
            if (d == 0) {
                int mean = calculationLocation(foreign, s);
                System.out.println("Зарубежных IT-компаний от общего числа: "+mean+"%");
            }
        }
    }

    protected int calculationLocation(int foreign, int s) {
        return foreign * 100 / s;
    }

    @Override
    public String name() {
        return "для вывода % иностранных компаний";
    }

    protected void baseExecute() {
    }
}