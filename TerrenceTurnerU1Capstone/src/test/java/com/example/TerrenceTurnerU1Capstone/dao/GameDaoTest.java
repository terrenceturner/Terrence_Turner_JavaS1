package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    private GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gameDao.getAllGames();
        gameList.stream()
                .forEach(game -> gameDao.deleteGame(game.getGame_id()));
    }

    @Test
    public void addGetDeleteGame(){

        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGame_id());

        assertEquals(game, game1);

        //delete
        gameDao.deleteGame(game.getGame_id());

        Game game2 = gameDao.getGame((game.getGame_id()));

        assertNull(game2);

    }


    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game = gameDao.addGame(game);

        game.setTitle("Halo");
        game.setEsrb_rating("M");
        game.setDescription("mature");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("Bungie");
        game.setQuantity(3);
        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGames();
        assertEquals(2,gameList.size());
    }


    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EA Sports");
        game.setQuantity(2);
        gameDao.addGame(game);

        game.setStudio("2K Studios");
        gameDao.updateGame(game);
        Game game1 = gameDao.getGame(game.getGame_id());
        assertEquals(game,game1);
    }

    @Test
    public void getGameByStudio() {
        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game = gameDao.addGame(game);

        //get
        List<Game> gameList = gameDao.getGameByStudio(game.getStudio());

        assertEquals(1,gameList.size());

    }

    @Test
    public void getGameByEsrb_rating() {
        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game = gameDao.addGame(game);

        //get
        List<Game> gameList = gameDao.getGameByEsrbRating(game.getEsrb_rating());

        assertEquals(1,gameList.size());

    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game = gameDao.addGame(game);

        //get
        List<Game> gameList = gameDao.getGameByTitle(game.getTitle());
        assertEquals(1,gameList.size());
    }
}