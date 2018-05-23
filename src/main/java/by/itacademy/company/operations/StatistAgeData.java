package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.Readers.FileReader;
import by.itacademy.company.Readers.FileReaderXml;
import by.itacademy.company.items.MenuItem;
import by.itacademy.company.items.StartBaseMenuItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class StatistAgeData extends StartBaseMenuItem implements MenuItem {
    public StatistAgeData(Data data, MenuItem startMenuItem) {
        super(data, startMenuItem);
    }

    @Override
    public void execute() {
        FileReader fileReader = new FileReaderXml();
        Set<Company> companyList = fileReader.read();
        long sum = 0;
        int d = companyList.size();
        for (Company companys : companyList) {
            long dateOfCreation = companys.getDateOfCreation().getTime();
            long s = companyList.size();
            sum = sum + dateOfCreation;
            --d;
            if (d == 0) {
                long medina = sum / s;
                long diff = System.currentTimeMillis() - medina;
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;
                long diffDays = diff / (24 * 60 * 60 * 1000);
                StringBuilder sb = new StringBuilder();
                sb.append(diffDays + " дней, ");
                sb.append(diffHours + " часов, ");
                sb.append(diffMinutes + " минут, ");
                sb.append(diffSeconds + " секунд");
                System.out.println(sb.toString());
            }
        }
    }
    protected void baseExecute() {
    }
    @Override
    public String name() {
        return "вывода среднего возраста компаний";
    }
}