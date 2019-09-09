package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameJdbcTemplateImpl implements GameDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_GAME_SQL =
            "insert into game (console_id, publisher_id, type_id) values (?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String UPDATE_GAME_SQL =
            "update game set console_id = ?, publisher_id = ?, type_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    private static final String  SELECT_GAMES_BY_CONSOLE_SQL =
            "select * from game where game_id = ?";

    private static final String  SELECT_GAMES_BY_PUBLISHER_SQL =
            "select * from game where game_id = ?";

    private static final String  SELECT_GAMES_BY_TYPE_SQL =
            "select * from game where game_id = ?";


    @Autowired
    public GameJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(
                INSERT_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        game.setGame_id(id);

        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this game id, return null
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getGameByConsole(int console_id) {
        return jdbcTemplate.query(
                SELECT_GAMES_BY_CONSOLE_SQL,
                this::mapRowToGame,
                console_id);
    }

    @Override
    public List<Game> getGameByPublisher(int publisher_id) {
        return jdbcTemplate.query(
                SELECT_GAMES_BY_PUBLISHER_SQL,
                this::mapRowToGame,
                publisher_id);
    }

    @Override
    public List<Game> getGameByType(int type_id) {
        return jdbcTemplate.query(
                SELECT_GAMES_BY_TYPE_SQL,
                this::mapRowToGame,
                type_id);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id(),
                game.getGame_id());

    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME, id);

    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setConsole_id(rs.getInt("console_id"));
        game.setPublisher_id(rs.getInt("publisher_id"));
        game.setType_id(rs.getInt("type_id"));


        return game;
    }
}
