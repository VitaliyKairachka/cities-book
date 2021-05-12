package sber.kairachka.service;

import org.junit.Before;
import org.junit.Test;
import sber.kairachka.domain.City;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearcherTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    List<City> testList = new ArrayList<>();
    Searcher searcher = new Searcher(testList);
    Printer printer = new Printer();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        testList.add(new City(
                1,
                "Адыгейск",
                "Адыгея",
                "Южный",
                12248,
                1973)
        );
        testList.add(new City(
                2,
                "Абакан",
                "Хакасия",
                "Сибирский",
                165183,
                1931)
        );
        testList.add(new City(
                3,
                "Майкоп",
                "Адыгея",
                "Южный",
                144246,
                1857)
        );
        testList.add(new City(
                4,
                "Горно-Алтайск",
                "Алтай",
                "Сибирский",
                56928,
                1830)
        );
    }

    @Test
    public void getAllCities() {
        printer.print(searcher.getAllCities());
        assertEquals("City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation=1973}\r\n" +
                        "City{name='Абакан', region='Хакасия', district='Сибирский', population=165183, foundation=1931}\r\n" +
                        "City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation=1857}\r\n" +
                        "City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation=1830}"
                , outputStream.toString().trim());
        outputStream.reset();
    }

    @Test
    public void getMaxPopulation() {
        printer.print(searcher.getMaxPopulation());
        assertEquals("[1] = 165183"
                , outputStream.toString().trim());
        outputStream.reset();
    }

    @Test
    public void getRegionsCount() {
        printer.print(searcher.getRegionsCount());
        assertEquals("Адыгея - 2\r\n" +
                        "Алтай - 1\r\n" +
                        "Хакасия - 1"
                , outputStream.toString().trim());
        outputStream.reset();
    }
}