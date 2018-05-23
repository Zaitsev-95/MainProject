package by.itacademy.company.operations;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.Data;
import by.itacademy.company.items.MenuItem;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class StatistEmployeeDataTest extends Data implements MenuItem {

    @Test
    public void oddNumber() {
        Set<Company> companyList = new TreeSet<>();
        Company company=new Company();
        Company company1=new Company();
        Company company2=new Company();
        company.setPersonal(5);
        company1.setPersonal(10);
        company2.setPersonal(12);
        companyList.add(company);
        companyList.add(company1);
        companyList.add(company2);
        StatistEmployeeData statistEmployeeData = new StatistEmployeeData(this, this);
        int actual=statistEmployeeData.calculationMedina(companyList);
        int expected = 10;
        assertEquals(actual, expected);//тест на нечетное количество компаний
    }

    @Test
    public void evenNumber() {
        Set<Company> companyList = new TreeSet<>();
        Company company=new Company();
        Company company1=new Company();
        Company company2=new Company();
        Company company3=new Company();
        company.setPersonal(5);
        company1.setPersonal(10);
        company2.setPersonal(12);
        company3.setPersonal(15);
        companyList.add(company);
        companyList.add(company1);
        companyList.add(company2);
        companyList.add(company3);
        StatistEmployeeData statistEmployeeData = new StatistEmployeeData(this, this);
        int actual=statistEmployeeData.calculationMedina(companyList);
        int expected = 11;
        assertEquals(actual, expected);//тест на четное количество компаний
    }

    @Override
    public void execute() {

    }
}