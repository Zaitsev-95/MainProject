package by.itacademy.company.Company;

import by.itacademy.company.Exception.CompanyBuilderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Company implements Comparable<Company> {
    private String name;
    private Date dateOfCreation;
    private List<String> specialization = new ArrayList<>();
    private int personal;
    private boolean isForeign;

    public List<String> getSpecialization() {
        return specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setSpecialization(List<String> specialization) {
        this.specialization = specialization;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return personal == company.personal &&
                isForeign == company.isForeign &&
                Objects.equals(name, company.name) &&
                Objects.equals(dateOfCreation, company.dateOfCreation) &&
                Objects.equals(specialization, company.specialization);
    }

    @Override
    public int hashCode() {

        return Objects.hash( name, dateOfCreation, specialization, personal, isForeign);
    }

    @Override
    public String toString() {
        return
                "Company{" +
                        "name='" + name + '\'' +
                        ", dateOfCreation=" + dateOfCreation +
                        ", specialization=" + specialization +
                        ", personal=" + personal +
                        ", isForeign=" + isForeign +
                        "}.";
    }

    @Override
    public int compareTo(Company o) {
        if (this.getPersonal() > o.getPersonal()) {
            return 1;
        } else if (this.getPersonal() < o.getPersonal()) {
            return -1;
        } else {
            return 0;
        }
    }
    public static class CompanyBuilder {

        private Company company = new Company();

        public static CompanyBuilder createCompanyBuilder() {
            return new CompanyBuilder();
        }

        public CompanyBuilder setName(String name) {
            company.setName(name);
            return this;
        }

        public CompanyBuilder setDateOfCreation(String setDateOfCreation) throws CompanyBuilderException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date date;
                date = sdf.parse(setDateOfCreation);
                company.setDateOfCreation(date);
                return this;
            } catch (ParseException e) {
                throw new CompanyBuilderException(e);
            }
        }
        public CompanyBuilder setSpecialization(List<String> specialization){
            company.setSpecialization(specialization);
            return this;
        }

        public CompanyBuilder setPersonal(String personal) {
            company.setPersonal(Integer.parseInt(personal));
            return this;
        }

        public CompanyBuilder setIsForeign(String isForeign) throws CompanyBuilderException {
            if (isForeign.equals("true")) company.setForeign(true);
            else if (isForeign.equals("false")) company.setForeign(false);
            else throw new CompanyBuilderException("Невозможно преобразовать значение здоровья");
            return this;
        }

        public Company getCompany() {
            return company;
        }
    }
}