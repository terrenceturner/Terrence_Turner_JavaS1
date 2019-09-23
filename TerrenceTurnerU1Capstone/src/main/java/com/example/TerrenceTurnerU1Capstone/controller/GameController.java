package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.dto.Game;
import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private ServiceLayer service;

    // Post
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody GameViewModel gameViewModel) {
        return service.saveGame(gameViewModel);
    }

    // Get Single Game
    @RequestMapping(value = "/game/{game_id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel getGame(@PathVariable int game_id){
        return service.findGame(game_id);
    }

    // Get All Games
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames(){
        return service.findAllGames();
    }

    // Put
    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody GameViewModel gameViewModel){
        service.updateGame(gameViewModel);
    }

    // Delete
    @RequestMapping(value = "/game/{game_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int game_id) {
        service.removeGame(game_id);
    }

    //Get by Studio
    @RequestMapping(value = "game/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByStudio(@PathVariable("studio") String studio) {
        return service.findGameByStudio(studio);
    }

    //Get by ESRB Rating
    @RequestMapping(value = "game/esrb/{esrb_rating}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByEsrb_Rating(@PathVariable("esrb_rating") String esrb_rating) {
        return service.findGameByEsrbRating(esrb_rating);
    }

    //Get by Studio
    @RequestMapping(value = "game/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByTitle(@PathVariable("title") String title) {
        return service.findGameByTitle(title);
    }
}
