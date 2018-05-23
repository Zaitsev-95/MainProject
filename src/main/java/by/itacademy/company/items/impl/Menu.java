package by.itacademy.company.items.impl;

import by.itacademy.company.Pattern.Singleton;
import by.itacademy.company.Thread.ThreadCounter;
import by.itacademy.company.items.MenuItem;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class Menu {
    private MenuItem startMenu = new StartMainMenu();

    public void start() throws ParserConfigurationException, SAXException, ParseException, IOException {
        Singleton.getInstance();
        ThreadCounter counter=new ThreadCounter();
        counter.start();
        startMenu.execute();
        counter.interrupt();
    }
}