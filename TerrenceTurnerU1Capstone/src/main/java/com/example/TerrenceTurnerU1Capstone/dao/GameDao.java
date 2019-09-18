package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Game;

import java.util.List;

public interface GameDao {

    Game getGame(int game_id);

    List<Game> getAllGames();

    Game addGame(Game game);

    void updateGame(Game game);

    void deleteGame(int game_id);

    List<Game> getGameByStudio (String studio);

    List<Game> getGameByEsrbRating (String esrb_rating);

    List<Game> getGameByTitle (String title);
}
