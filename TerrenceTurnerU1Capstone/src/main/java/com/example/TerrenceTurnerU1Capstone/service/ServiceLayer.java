package com.example.TerrenceTurnerU1Capstone.service;


import com.example.TerrenceTurnerU1Capstone.dao.*;
import com.example.TerrenceTurnerU1Capstone.dto.Console;
import com.example.TerrenceTurnerU1Capstone.dto.Game;
import com.example.TerrenceTurnerU1Capstone.dto.Invoice;
import com.example.TerrenceTurnerU1Capstone.dto.TShirt;
import com.example.TerrenceTurnerU1Capstone.viewmodel.ConsoleViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.GameViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.InvoiceViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class ServiceLayer {

    //Properties
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private TShirtDao tShirtDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;

    //Constructor
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, TShirtDao tShirtDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.tShirtDao = tShirtDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }


    //ConsoleViewModel
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemory_amount(consoleViewModel.getMemory_amount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);
        consoleViewModel.setConsole_id(console.getConsole_id());

        return consoleViewModel;
    }

    public ConsoleViewModel findConsole(int console_id){
        Console console = consoleDao.getConsole(console_id);
        return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        consoleDao.getAllConsoles().stream().forEach(console -> cvmList.add(buildConsoleViewModel(console)));

        return cvmList;
    }

    public ConsoleViewModel updateConsole(ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setConsole_id(consoleViewModel.getConsole_id());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemory_amount(consoleViewModel.getMemory_amount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);

        return buildConsoleViewModel(console);
    }

    public void removeConsole(int console_id) {
        consoleDao.deleteConsole(console_id);
    }

    public List<ConsoleViewModel> findConsoleByManufacturer(String manufacturer) {
        List<Console> consolesList = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        consolesList.stream()
                .forEach(console ->  {
                    ConsoleViewModel consoleView = buildConsoleViewModel(console);
                    consoleViewModelList.add(consoleView);
                });

        return consoleViewModelList;
    }

    //GameViewModel
    public GameViewModel saveGame(GameViewModel gameViewModel){
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrb_rating(gameViewModel.getErsb_rating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        game = gameDao.addGame(game);
        gameViewModel.setGame_id(game.getGame_id());

        return gameViewModel;
    }

    public GameViewModel findGame(int game_id){
        Game game = gameDao.getGame(game_id);
        return buildGameViewModel(game);

    }

    public List<GameViewModel> findAllGames() {
        List<GameViewModel> gameViewModelList = new ArrayList<>();
        gameDao.getAllGames().stream().forEach(game -> gameViewModelList.add(buildGameViewModel(game)));

        return gameViewModelList;
    }


    public GameViewModel updateGame(GameViewModel gameViewModel){
        Game game = new Game();
        game.setGame_id(gameViewModel.getGame_id());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrb_rating(gameViewModel.getErsb_rating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        gameDao.updateGame(game);

        return buildGameViewModel(game);
    }

    public void removeGame(int game_id) {
        gameDao.deleteGame(game_id);
    }

    public List<GameViewModel> findGameByStudio(String studio) {
        List<Game> gameList = gameDao.getGameByStudio(studio);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        gameList.stream()
                .forEach(game ->  {
                    GameViewModel gameView = buildGameViewModel(game);
                    gameViewModelList.add(gameView);
                });

        return gameViewModelList;
    }

    public List<GameViewModel> findGameByEsrbRating(String esrb_rating){
        List<Game> gameList = gameDao.getGameByEsrbRating(esrb_rating);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        gameList.stream()
                .forEach(game -> {
                    GameViewModel gameView = buildGameViewModel(game);
                    gameViewModelList.add(gameView);
                });

        return gameViewModelList;
    }

    public List<GameViewModel> findGameByTitle(String title){
        List<Game> gameList = gameDao.getGameByTitle(title);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        gameList.stream()
                .forEach(game -> {
                    GameViewModel gameView = buildGameViewModel(game);
                    gameViewModelList.add(gameView);
                });

        return gameViewModelList;
    }


    //TShirtViewModel
    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel){
        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.addTShirt(tShirt);
        tShirtViewModel.setT_shirt_id(tShirt.getT_shirt_id());

        return tShirtViewModel;
    }

    public TShirtViewModel findTShirt(int t_shirt_id){
        TShirt tShirt = tShirtDao.getTShirt(t_shirt_id);
        return buildTShirtViewModel(tShirt);

    }

    public List<TShirtViewModel> findAllTshirts() {
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();
        tShirtDao.getAllTShirts().stream().forEach(tshirt -> tShirtViewModelList.add(buildTShirtViewModel(tshirt)));

        return tShirtViewModelList;
    }

    public TShirtViewModel updateTShirt(TShirtViewModel tShirtViewModel){
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(tShirt.getT_shirt_id());
        tShirt.setSize(tShirt.getSize());
        tShirt.setColor(tShirt.getColor());
        tShirt.setDescription(tShirt.getDescription());
        tShirt.setPrice(tShirt.getPrice());
        tShirt.setQuantity(tShirt.getQuantity());

        tShirtDao.updateTShirt(tShirt);

        return buildTShirtViewModel(tShirt);
    }

    public void removeTShirt(int t_shirt_id) {
        tShirtDao.deleteTShirt(t_shirt_id);
    }

    public List<TShirtViewModel> findTShirtByColor(String color){
        List<TShirt> tShirtList = tShirtDao.getTShirtByColor(color);
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        tShirtList.stream()
                .forEach(tShirt -> {
                    TShirtViewModel tShirtView = buildTShirtViewModel(tShirt);
                    tShirtViewModelList.add(tShirtView);
                });

        return tShirtViewModelList;
    }

    public List<TShirtViewModel> findTShirtBySize(String size){
        List<TShirt> tShirtList = tShirtDao.getTShirtBySize(size);
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        tShirtList.stream()
                .forEach(tShirt -> {
                    TShirtViewModel tShirtView = buildTShirtViewModel(tShirt);
                    tShirtViewModelList.add(tShirtView);
                });

        return tShirtViewModelList;
    }


    //InvoiceViewModel
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        if (!(invoiceViewModel.getState().equals(salesTaxRateDao.getSalesTaxRate(invoiceViewModel.getState()).getState()))){
            throw new IllegalArgumentException("Sorry! Order should have valid state ");
        }
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItem_type(invoiceViewModel.getItem_type());
        invoice.setItem_id(invoiceViewModel.getItem_id());
        invoice.setUnit_price(invoiceViewModel.getUnit_price());
        if (invoiceViewModel.getQuantity() <= 0) {
            throw new IllegalArgumentException("Sorry! Quantity should be greater than 0");
        }
        invoice.setQuantity(invoiceViewModel.getQuantity());
        switch(invoiceViewModel.getItem_type()){
            case "consoles":
                Console console =  consoleDao.getConsole(invoiceViewModel.getItem_id());
                if(invoiceViewModel.getQuantity() <= console.getQuantity()){
                    console.setQuantity(console.getQuantity() - invoiceViewModel.getQuantity());
                    consoleDao.updateConsole(console);
                } else {
                    throw new IllegalArgumentException("Sorry! Not enough consoles in stock");
                }
            case "games":
                Game game =  gameDao.getGame(invoiceViewModel.getItem_id());
                if(invoiceViewModel.getQuantity() <= game.getQuantity()){
                    game.setQuantity(game.getQuantity() - invoiceViewModel.getQuantity());
                    gameDao.updateGame(game);
                } else {
                    throw new IllegalArgumentException("Sorry! Not enough games in stock");
                }
            case "tshirt":
                TShirt tshirt =  tShirtDao.getTShirt(invoiceViewModel.getItem_id());
                if(invoiceViewModel.getQuantity() <= tshirt.getQuantity()){
                    tshirt.setQuantity(tshirt.getQuantity() - invoiceViewModel.getQuantity());
                    tShirtDao.updateTShirt(tshirt);
                } else {
                    throw new IllegalArgumentException("Sorry! Not enough tshirts in stock");
                }
        }

        invoice.setSubtotal(calculateSubtotal(invoice));

        BigDecimal processingFee = processingFeeDao.getProcessingFee(invoiceViewModel.getItem_type()).getFee();
        if (invoiceViewModel.getQuantity() > 10 ) {
            invoice.setProcessing_fee(processingFee.add(new BigDecimal(15.49)));
        }else{
            invoice.setProcessing_fee(processingFee);
        }

        invoice.setTax((salesTaxRateDao.getSalesTaxRate(invoiceViewModel.getState())).getRate());
        invoice.setTotal((invoice.getTax()).add(invoice.getProcessing_fee()).add(invoice.getSubtotal()));


        Invoice invoiceAdded = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setInvoice_id(invoiceAdded.getInvoice_id());
        return invoiceViewModel;
    }

    public BigDecimal calculateSubtotal(Invoice invoice){

        return (new BigDecimal(invoice.getQuantity())).multiply(invoice.getUnit_price());

    }
    public BigDecimal calculateTotal(InvoiceViewModel invoiceViewModel){

        return (invoiceViewModel.getTax()).add(invoiceViewModel.getProcessing_fee()).add(invoiceViewModel.getSubtotal());

    }
    public InvoiceViewModel findInvoice(int invoice_id){
        Invoice invoice = invoiceDao.getInvoice(invoice_id);
        return buildInvoiceViewModel(invoice);

    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();
        invoiceDao.getAllInvoices().stream().forEach(invoice -> invoiceViewModelList.add(buildInvoiceViewModel(invoice)));

        return invoiceViewModelList;
    }



    //Build Methods
    private ConsoleViewModel buildConsoleViewModel(Console console){

        ConsoleViewModel consoleView = new ConsoleViewModel();
        consoleView.setConsole_id(console.getConsole_id());
        consoleView.setModel(console.getModel());
        consoleView.setManufacturer(console.getManufacturer());
        consoleView.setMemory_amount(console.getMemory_amount());
        consoleView.setProcessor(console.getProcessor());
        consoleView.setPrice(console.getPrice());
        consoleView.setQuantity(console.getQuantity());

        return consoleView;
    }

    private GameViewModel buildGameViewModel(Game game){

        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(game.getGame_id());
        gameView.setErsb_rating(game.getEsrb_rating());
        gameView.setDescription(game.getDescription());
        gameView.setPrice(game.getPrice());
        gameView.setStudio(game.getStudio());
        gameView.setQuantity(game.getQuantity());

        return gameView;
    }

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt){

        TShirtViewModel tShirtView = new TShirtViewModel();
        tShirtView.setT_shirt_id(tShirt.getT_shirt_id());
        tShirtView.setSize(tShirt.getSize());
        tShirtView.setColor(tShirt.getColor());
        tShirtView.setDescription(tShirt.getDescription());
        tShirtView.setPrice(tShirt.getPrice());
        tShirtView.setQuantity(tShirt.getQuantity());

        return tShirtView;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){

        InvoiceViewModel invoiceView = new InvoiceViewModel();
        invoiceView.setInvoice_id(invoice.getInvoice_id());
        invoiceView.setName(invoice.getName());
        invoiceView.setStreet(invoice.getStreet());
        invoiceView.setCity(invoice.getCity());
        invoiceView.setState(invoice.getState());
        invoiceView.setZipcode(invoice.getZipcode());
        invoiceView.setItem_type(invoice.getItem_type());
        invoiceView.setItem_id(invoice.getItem_id());
        invoiceView.setUnit_price(invoice.getUnit_price());
        invoiceView.setQuantity(invoice.getQuantity());
        invoiceView.setSubtotal(invoice.getSubtotal());
        invoiceView.setTax(invoice.getTax());
        invoiceView.setProcessing_fee(invoice.getProcessing_fee());
        invoiceView.setTotal(invoice.getTotal());

        return invoiceView;
    }



}
