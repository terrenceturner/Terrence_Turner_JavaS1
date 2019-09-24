package com.example.TerrenceTurnerU1Capstone.controller;

import com.example.TerrenceTurnerU1Capstone.dto.Game;
import com.example.TerrenceTurnerU1Capstone.service.ServiceLayer;
import com.example.TerrenceTurnerU1Capstone.viewmodel.GameViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameControllerTest.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getGameByIdShouldReturnGameWithIdJson() throws Exception{
        GameViewModel game = new GameViewModel();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game.setGame_id(1);


        Optional<GameViewModel> returnVal = Optional.of(game);

        String outputJson = mapper.writeValueAsString(game);

        when(service.findGame(1)).thenReturn(returnVal.get());


        this.mockMvc.perform(get("/game/1"))
                .andDo(print())
                .andExpect(status().isOk())
                //use the objectmapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameThatDoesNotExistReturns404() throws Exception {

        // Since findById returns an Optional, we create one. But this time without a value
        // as that would be the expected behavior if we searched for a non-existant id
//        Optional<GameViewModel> returnVal = Optional.empty();
        GameViewModel returnVal = null;

        int idForGameThatDoesNotExist = 100;

        when(service.findGame(idForGameThatDoesNotExist)).thenReturn(returnVal);

        this.mockMvc.perform(get("/game" + idForGameThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createGameShouldReturnCreatedGame() throws Exception {

        GameViewModel inputGame = new GameViewModel();
        inputGame.setTitle("NBA 2K");
        inputGame.setEsrb_rating("E");
        inputGame.setDescription("everyone");
        inputGame.setPrice(new BigDecimal("59.99"));
        inputGame.setStudio("2K Studios");
        inputGame.setQuantity(2);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputGame);

        GameViewModel outputGame = new GameViewModel();
        outputGame.setTitle("NBA 2K");
        outputGame.setEsrb_rating("E");
        outputGame.setDescription("everyone");
        outputGame.setPrice(new BigDecimal("59.99"));
        outputGame.setStudio("2K Studios");
        outputGame.setQuantity(2);
        outputGame.setGame_id(1);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputGame);

        when(service.saveGame(inputGame)).thenReturn(outputGame);

        this.mockMvc.perform(post("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGamesShouldReturnAListOfGames() throws Exception {

        GameViewModel game = new GameViewModel();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game.setGame_id(1);

        GameViewModel game2 = new GameViewModel();
        game2.setTitle("Halo");
        game2.setEsrb_rating("M");
        game2.setDescription("mature");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Bungie");
        game2.setQuantity(3);
        game2.setGame_id(2);

        List<GameViewModel> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);

        //Object to JSON in String
        when(service.findAllGames()).thenReturn(gameList);

        List<GameViewModel> listChecker = new ArrayList<>();
        listChecker.addAll(gameList);
        //To confirm the test is testing what we think it is... add another Game.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Game(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void updateGameShouldReturnAnUpdatedGames() throws Exception {

        Game game = new Game();
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);
        game.setGame_id(1);

        //these will be the same
        String inputJson = mapper.writeValueAsString(game);
        String outputJson = mapper.writeValueAsString(game);

        this.mockMvc.perform(put("/game" + game.getGame_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void deleteGameIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void getGamesByStudio() throws Exception{

        GameViewModel game = new GameViewModel();
        game.setGame_id(1);
        game.setTitle("NBA 2K20");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(12);

        GameViewModel game2 = new GameViewModel();
        game2.setGame_id(2);
        game2.setTitle("Halo");
        game2.setEsrb_rating("M");
        game2.setDescription("mature");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Bungie");
        game2.setQuantity(13);

        GameViewModel game3 = new GameViewModel();
        game3.setGame_id(3);
        game3.setTitle("WWE 2K20");
        game3.setEsrb_rating("E");
        game3.setDescription("everyone");
        game3.setPrice(new BigDecimal(45.99));
        game3.setStudio("2K Studios");
        game3.setQuantity(10);

        List<GameViewModel> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);
        gameList.add(game3);

        when(service.findGameByStudio("2K Studios")).thenReturn(gameList);

        List<GameViewModel>  gameList2 = new ArrayList<>();

        gameList2.addAll(gameList);

        String outputJson = mapper.writeValueAsString(gameList2);

        this.mockMvc.perform(get("/game/studio/2KStudios"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(outputJson));


    }

    @Test
    public void getGamesByErsbRating() throws Exception{

        GameViewModel game = new GameViewModel();
        game.setGame_id(1);
        game.setTitle("NBA 2K20");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(12);

        GameViewModel game2 = new GameViewModel();
        game2.setGame_id(2);
        game2.setTitle("Halo");
        game2.setEsrb_rating("M");
        game2.setDescription("mature");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Bungie");
        game2.setQuantity(13);

        GameViewModel game3 = new GameViewModel();
        game3.setGame_id(3);
        game3.setTitle("WWE 2K20");
        game3.setEsrb_rating("E");
        game3.setDescription("everyone");
        game3.setPrice(new BigDecimal(45.99));
        game3.setStudio("2K Studios");
        game3.setQuantity(10);

        List<GameViewModel> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);
        gameList.add(game3);

        when(service.findGameByEsrbRating("M")).thenReturn(gameList);

        List<GameViewModel>  gameList2 = new ArrayList<>();

        gameList2.addAll(gameList);

        String outputJson = mapper.writeValueAsString(gameList2);

        this.mockMvc.perform(get("/game/esrbRating/M"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getGamesByTitle() throws Exception{

        GameViewModel game = new GameViewModel();
        game.setGame_id(1);
        game.setTitle("NBA 2K20");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(12);

        GameViewModel game2 = new GameViewModel();
        game2.setGame_id(2);
        game2.setTitle("Halo");
        game2.setEsrb_rating("M");
        game2.setDescription("mature");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Bungie");
        game2.setQuantity(13);

        GameViewModel game3 = new GameViewModel();
        game3.setGame_id(3);
        game3.setTitle("WWE 2K20");
        game3.setEsrb_rating("E");
        game3.setDescription("everyone");
        game3.setPrice(new BigDecimal(45.99));
        game3.setStudio("2K Studios");
        game3.setQuantity(10);

        List<GameViewModel> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game2);
        gameList.add(game3);

        when(service.findGameByTitle("NBA 2K20")).thenReturn(gameList);

        List<GameViewModel>  gameList2 = new ArrayList<>();

        gameList2.addAll(gameList);

        String outputJson = mapper.writeValueAsString(gameList2);

        this.mockMvc.perform(get("/game/title/NBA2K20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));


    }


}