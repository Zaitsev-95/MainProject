package by.itacademy.company.Company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class XmlCompanyDeserializer {
    public Set<Company> deserialize(Document document) {
        Element element = (Element) document.getElementsByTagName("companies").item(0);
        NodeList companiesNodeList = document.getElementsByTagName("company");
        Set<Company> companyList = new TreeSet<>();
        for (int i = 0; i < companiesNodeList.getLength(); i++) {
            if (companiesNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element companyElement = (Element) companiesNodeList.item(i);
                Company company = new Company();
                NodeList childNodes = companyElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);
                        switch (childElement.getNodeName()) {
                            case "name": {
                                company.setName(childElement.getTextContent());
                            }
                            break;
                            case "dateOfCreation": {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                                try {
                                    company.setDateOfCreation(simpleDateFormat.parse(childElement.getTextContent()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                            case "specializationList": {
                                List<String> strings = new ArrayList<>();
                                NodeList childNodes1 = childElement.getChildNodes();
                                for (int z = 0; z < childNodes1.getLength(); z++) {
                                    if (childNodes1.item(z).getNodeType() == Node.ELEMENT_NODE) {
                                        Element childSpecializationListElement = (Element) childNodes1.item(z);
                                        strings.add(childSpecializationListElement.getTextContent());
                                    }
                                    company.setSpecialization(strings);
                                }
                            }
                            break;
                            case "personal": {
                                company.setPersonal(Integer.valueOf(childElement.getTextContent()));
                            }
                            break;
                            case "isForeign": {
                                company.setForeign(Boolean.valueOf(childElement.getTextContent()));
                            }
                            break;
                        }
                    }
                }
                companyList.add(company);
            }
        }
        return companyList;
    }
}