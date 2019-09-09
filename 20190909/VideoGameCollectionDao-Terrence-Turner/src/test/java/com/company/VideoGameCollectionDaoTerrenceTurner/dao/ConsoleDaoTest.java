package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Console;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Game;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Publisher;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    ConsoleDao consoleDao;

    @Autowired
    TypeDao typeDao;

    @Before
    public void setUp() throws Exception {

        // Clean up the test db
        List<Game> gameList = gameDao.getAllGames();
        for (Game g : gameList) {
            gameDao.deleteGame(g.getGame_id());
        }

        List<Console> consoleList = consoleDao.getAllConsoles();

        for (Console c : consoleList) {
            consoleDao.deleteConsole(c.getConsole_id());
        }

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisher_id());
        }

        List<Type> typeList = typeDao.getAllTypes();

        for (Type t : typeList) {
            typeDao.deleteType(t.getType_id());
        }
    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsole_id());

        assertEquals(console, console1);

        consoleDao.deleteConsole(console.getConsole_id());

        console1 = consoleDao.getConsole(console.getConsole_id());

        assertNull(console1);

    }

    @Test
    public void updateConsole(){
        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        console.setName("PS4");
        console.setYear("2014");

        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsole_id());

        assertEquals(console, console1);

    }

    @Test
    public void getAllConsoles(){

        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setConsole_id(222);
        console1.setName("PS4");
        console1.setYear("2015");
        console1 = consoleDao.addConsole(console1);

        Console console2 = new Console();
        console2.setConsole_id(333);
        console2.setName("Nintendo Switch");
        console2.setYear("2017");
        console2 = consoleDao.addConsole(console2);

        List<Console> consoles = consoleDao.getAllConsoles();

        assertEquals(3, consoles.size());
    }


}