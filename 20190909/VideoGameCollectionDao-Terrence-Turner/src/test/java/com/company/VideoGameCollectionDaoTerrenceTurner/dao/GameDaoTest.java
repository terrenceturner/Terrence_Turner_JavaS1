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
public class GameDaoTest {

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
    public void addGetDeleteGame() {

        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGame_id());

        assertEquals(game, game1);

        gameDao.deleteGame(game.getGame_id());

        game1 = gameDao.getGame(game.getGame_id());

        assertNull(game1);
    }

    @Test
    public void updateGame(){

        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        game.setGame_id(555);

        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGame_id());

        assertEquals(game, game1);

    }


    @Test
    public void getAllGames(){

        Console console = new Console();
        console.setConsole_id(111);
        console.setName("Xbox One");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisher_id(323);
        publisher1.setName("Bungie");
        publisher1.setWebsite("bungie.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Type type1 = new Type();
        type1.setType_id(521);
        type1.setName("First Person Shooter");
        type1.setDescription("Space zombies");
        type1 = typeDao.addType(type1);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(555);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type1.getType_id());
        game = gameDao.addGame(game);

        List<Game> games = gameDao.getAllGames();

        assertEquals(2, games.size());
    }

    @Test
    public void getGamesByConsole(){

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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisher_id(323);
        publisher1.setName("Bungie");
        publisher1.setWebsite("bungie.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Type type1 = new Type();
        type1.setType_id(521);
        type1.setName("First Person Shooter");
        type1.setDescription("Space zombies");
        type1 = typeDao.addType(type1);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(555);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type1.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(664);
        game.setConsole_id(console1.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type1.getType_id());

        List<Game> games = gameDao.getGameByPublisher(console.getConsole_id());
        assertEquals(games.size(), 0);

        games = gameDao.getGameByPublisher(console1.getConsole_id());
        assertEquals(games.size(), 1);

    }

    @Test
    public void getGamesByPublisher(){

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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisher_id(323);
        publisher1.setName("Bungie");
        publisher1.setWebsite("bungie.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Type type1 = new Type();
        type1.setType_id(521);
        type1.setName("First Person Shooter");
        type1.setDescription("Space zombies");
        type1 = typeDao.addType(type1);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(555);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type1.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(664);
        game.setConsole_id(console1.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type1.getType_id());

        List<Game> games = gameDao.getGameByPublisher(publisher.getPublisher_id());
        assertEquals(games.size(), 1);

        games = gameDao.getGameByPublisher(publisher1.getPublisher_id());
        assertEquals(games.size(), 1);

    }

    @Test
    public void getGamesByType(){

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

        Publisher publisher = new Publisher();
        publisher.setPublisher_id(222);
        publisher.setName("Microsoft");
        publisher.setWebsite("microsoft.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisher_id(323);
        publisher1.setName("Bungie");
        publisher1.setWebsite("bungie.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        Type type = new Type();
        type.setType_id(333);
        type.setName("RPG");
        type.setDescription("Steampunk zombies");
        type = typeDao.addType(type);

        Type type1 = new Type();
        type1.setType_id(521);
        type1.setName("First Person Shooter");
        type1.setDescription("Space zombies");
        type1 = typeDao.addType(type1);

        Game game = new Game();
        game.setGame_id(444);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(555);
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type1.getType_id());
        game = gameDao.addGame(game);

        game = new Game();
        game.setGame_id(664);
        game.setConsole_id(console1.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type1.getType_id());

        List<Game> games = gameDao.getGameByType(type.getType_id());
        assertEquals(games.size(), 1);

        games = gameDao.getGameByType(type1.getType_id());
        assertEquals(games.size(), 1);

    }
}