package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    List<Game> getGameByConsole(int console_id);

    List<Game> getGameByPublisher(int publisher_id);

    List<Game> getGameByType(int type_id);

    void updateGame(Game game);

    void deleteGame(int id);
}
