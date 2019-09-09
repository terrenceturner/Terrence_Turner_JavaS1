package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Console;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Game;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Publisher;
import com.company.VideoGameCollectionDaoTerrenceTurner.model.Type;
import org.assertj.core.util.diff.Delta;
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
public class TypeDaoTest {

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
    public void addGetDeleteType() {

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Type type1 = typeDao.getType(type.getType_id());

        assertEquals(type, type1);

        typeDao.deleteType(type.getType_id());

        type1 = typeDao.getType(type.getType_id());

        assertNull(type1);
    }

    @Test
    public void updateType(){

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        type.setName("FPS");
        type.setDescription("Vampire Zombies");

        typeDao.updateType(type);

        Type type1 = typeDao.getType(type.getType_id());

        assertEquals(type, type1);
    }

    @Test
    public void getAllTypes(){

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        type = new Type();
        type.setType_id(521);
        type.setName("First Person Shooter");
        type.setDescription("Space zombies");
        type = typeDao.addType(type);

        List<Type> typeList = typeDao.getAllTypes();

        assertEquals(2, typeList.size());
    }
}