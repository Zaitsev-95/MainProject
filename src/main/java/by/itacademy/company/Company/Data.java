package by.itacademy.company.Company;
import by.itacademy.company.comparator.AgeComparator;

import java.util.Set;
import java.util.TreeSet;
public class Data {
    private Set<Company> list = new TreeSet<>(new AgeComparator());
    public Set<Company> list() {
        return list;
    }
    public void addCompanyInData(Company company) {
        list.add(company);
    }
}