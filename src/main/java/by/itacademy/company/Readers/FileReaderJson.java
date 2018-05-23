package by.itacademy.company.Readers;

import by.itacademy.company.Company.Company;
import by.itacademy.company.Company.OnlineBaseJSON;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FileReaderJson implements FileReader {
    @Override
    public Set<Company> read() {
        Set<Company> listCompanies;
        OnlineBaseJSON onlineBaseJSON = new OnlineBaseJSON();
        listCompanies= onlineBaseJSON.getOnlineBase();
        return listCompanies;
    }
}