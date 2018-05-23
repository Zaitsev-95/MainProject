package by.itacademy.company.operations;

import by.itacademy.company.Company.Data;
import by.itacademy.company.items.MenuItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatistLocationDataTest extends Data implements MenuItem {

    @Test
    public void calculationLocation() {
        StatistLocationData statistLocationData = new StatistLocationData(this, this);
        int actual = statistLocationData.calculationLocation(2, 4);
        int expected = 50;
        assertEquals(actual, expected);
    }

    @Override
    public void execute() {
    }
}