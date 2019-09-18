package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {

    //JDBC Property and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Prepared Statements
    private static final String INSERT_GAME_SQL = "INSERT INTO game (title, esrb_rating, description, price, studio, quantity) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL = "SELECT * FROM game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL = "SELECT * FROM game";

    private static final String DELETE_GAME_SQL = "DELETE FROM game where game_id = ?";

    private static final String UPDATE_GAME_SQL = "UPDATE game SET title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ?  where game_id = ?";

    private static final String GET_GAME_BY_STUDIO_SQL = "GET * FROM game WHERE studio = ?";

    private static final String GET_GAME_BY_ESRB_RATING_SQL = "GET * FROM game WHERE esrb_rating = ?";

    private static final String GET_GAME_BY_TITLE_SQL = "GET * FROM game WHERE title = ?";

    //Method Implementations
    @Override
    public Game getGame(int game_id) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_GAME_SQL,
                    this::mapRowToGame,
                    game_id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(
                INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        game.setGame_id(id);

        return game;
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGame_id());


    }

    @Override
    public void deleteGame(int game_id) {
        jdbcTemplate.update(DELETE_GAME_SQL, game_id);

    }

    @Override
    public List<Game> getGameByStudio(String studio) {
        return jdbcTemplate.query(GET_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio);
    }

    @Override
    public List<Game> getGameByEsrbRating(String esrb_rating) {
        return jdbcTemplate.query(GET_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, esrb_rating);
    }

    @Override
    public List<Game> getGameByTitle(String title) {
        return jdbcTemplate.query(GET_GAME_BY_TITLE_SQL, this::mapRowToGame, title);
    }


    //Row Mapper
    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
