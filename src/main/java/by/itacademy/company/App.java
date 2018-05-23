package by.itacademy.company;

import by.itacademy.company.items.impl.Menu;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, ParseException, IOException {
        Menu menu = new Menu();
        menu.start();
    }
}