package by.itacademy.company.comparator;

import by.itacademy.company.Company.Company;

import java.util.Comparator;
import java.util.Date;

public class AgeComparator implements Comparator<Company> {
    @Override
    public int compare(Company o1, Company o2) {
        Date date1 = o1.getDateOfCreation();
        Date date2 = o2.getDateOfCreation();
        if (date1.after(date2)) {
            return 1;
        } else if (date1.before(date2)) {
            return -1;
        } else {
            return 0;
        }
    }
}