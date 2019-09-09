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
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher, publisher1);

        publisherDao.deletePublisher(publisher.getPublisher_id());

        publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertNull(publisher1);

    }

    @Test
    public void updatePublisher(){

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher.setName("Bungie");
        publisher.setWebsite(("bungie.com"));

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher, publisher1);

    }

    @Test
    public void getAllPublishers(){

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setPublisher_id(323);
        publisher.setName("Bungie");
        publisher.setWebsite("bungie.com");
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publishers = publisherDao.getAllPublishers();

        assertEquals(2, publishers.size());
    }
}