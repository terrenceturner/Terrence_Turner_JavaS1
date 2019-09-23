package com.example.TerrenceTurnerU1Capstone.service;

import com.example.TerrenceTurnerU1Capstone.dao.*;
import com.example.TerrenceTurnerU1Capstone.dto.*;
import com.example.TerrenceTurnerU1Capstone.viewmodel.ConsoleViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.GameViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.InvoiceViewModel;
import com.example.TerrenceTurnerU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    ConsoleDao consoleDao;
    GameDao gameDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxDaoMock();

        service = new ServiceLayer(consoleDao,gameDao,invoiceDao,tShirtDao,processingFeeDao,salesTaxRateDao);
    }
    private void setUpConsoleDaoMock(){
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);

        Console console2 = new Console();
        console2.setModel("SSX123");
        console2.setManufacturer("sony");
        console2.setMemory_amount("1GB");
        console2.setProcessor("ROX");
        console2.setPrice(new BigDecimal("500.00"));
        console2.setQuantity(9);

        Console updatedConsole = new Console();
        updatedConsole.setConsole_id(3);
        updatedConsole.setModel("switch");
        updatedConsole.setManufacturer("nintendo");
        updatedConsole.setMemory_amount("4gb");
        updatedConsole.setProcessor("RAM");
        updatedConsole.setPrice(new BigDecimal("23.00"));
        updatedConsole.setQuantity(2);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(2);
        doReturn(updatedConsole).when(consoleDao).updateConsole(updatedConsole);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).getConsoleByManufacturer(console.getManufacturer());


    }
    private void setUpGameDaoMock(){
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("NBA 2K");
        game.setEsrb_rating("E");
        game.setDescription("everyone");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("2K Studios");
        game.setQuantity(2);

        Game game2 = new Game();
        game2.setTitle("Halo");
        game2.setEsrb_rating("M");
        game2.setDescription("mature");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("Bungie");
        game2.setQuantity(3);

        Game updatedGame = new Game();
        updatedGame.setTitle("WWE 2K20");
        updatedGame.setEsrb_rating("E");
        updatedGame.setDescription("everyone");
        updatedGame.setPrice(new BigDecimal("45.99"));
        updatedGame.setStudio("2K Studios");
        updatedGame.setQuantity(10);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(updatedGame).when(gameDao).updateGame(updatedGame);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGameByEsrbRating("E");
        doReturn(gameList).when(gameDao).getGameByTitle("Halo");
        doReturn(gameList).when(gameDao).getGameByStudio("2K Studios");

    }
    private void setUpTShirtDaoMock() {

        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(1);
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);

        TShirt tShirt2 = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Grey");
        tShirt.setDescription("An okay shirt");
        tShirt.setPrice(new BigDecimal("24.00"));
        tShirt.setQuantity(3);

        TShirt updatedTShirt = new TShirt();
        updatedTShirt.setT_shirt_id(1);
        updatedTShirt.setSize("L");
        updatedTShirt.setColor("White");
        updatedTShirt.setDescription("A Shirt");
        updatedTShirt.setPrice(new BigDecimal("23.00"));
        updatedTShirt.setQuantity(6);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
        doReturn(tShirt).when(tShirtDao).getTShirt(1);
        doReturn(updatedTShirt).when(tShirtDao).updateTShirt(updatedTShirt);
        doReturn(tShirtList).when(tShirtDao).getAllTShirts();
        doReturn(tShirtList).when(tShirtDao).getTShirtBySize(("M"));
        doReturn(tShirtList).when(tShirtDao).getTShirtByColor("Black");
    }

    private void setUpInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("u");
        processingFee.setFee(BigDecimal.valueOf(1.49));

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(BigDecimal.valueOf(76.00));

        Invoice invoice = new Invoice();
        invoice.setInvoice_id(2);
        invoice.setName("invoice");
        invoice.setStreet("123 Main St");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("72194");
        invoice.setItem_type("itemType");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("3.25"));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal("35.50"));
        invoice.setTax(new BigDecimal("2.30"));
        invoice.setProcessing_fee(new BigDecimal("4.00"));
        invoice.setTotal(new BigDecimal("62.50"));

        Invoice invoice2 = new Invoice();

        invoice.setName("invoice");
        invoice.setStreet("123 Main St");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipcode("72194");
        invoice.setItem_type("itemType");
        invoice.setItem_id(2);
        invoice.setUnit_price(new BigDecimal("3.25"));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal("35.50"));
        invoice.setTax(new BigDecimal("2.30"));
        invoice.setProcessing_fee(new BigDecimal("4.00"));
        invoice.setTotal(new BigDecimal("62.50"));


        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(2);
        doReturn(processingFee).when(processingFeeDao).getProcessingFee(anyString());
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate(anyString());
    }

    private void setUpSalesTaxDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("CA");
        salesTaxRate.setRate(new BigDecimal(".50"));

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("CA");
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type("t-shirt");
        processingFee.setFee(new BigDecimal("1.98"));

        doReturn(processingFee).when(processingFeeDao).getProcessingFee("t-shirt");
    }

    @Test
    public void saveFindConsole() {
        ConsoleViewModel consoleView = new ConsoleViewModel();
        consoleView.setModel("X123");
        consoleView.setManufacturer("microsoft");
        consoleView.setMemory_amount("16GB");
        consoleView.setProcessor("AMD");
        consoleView.setPrice(new BigDecimal("450.00"));
        consoleView.setQuantity(2);
        consoleView = service.saveConsole(consoleView);

        //find console
        ConsoleViewModel consoleFromService = service.findConsole(consoleView.getConsole_id());
        assertEquals(consoleView,consoleFromService);
    }


    @Test
    public void findConsoleByManufacturer() {
        ConsoleViewModel consoleView = new ConsoleViewModel();
//
        consoleView.setModel("X123");
        consoleView.setManufacturer("microsoft");
        consoleView.setMemory_amount("16GB");
        consoleView.setProcessor("AMD");
        consoleView.setPrice(new BigDecimal("450.00"));
        consoleView.setQuantity(2);
        consoleView = service.saveConsole(consoleView);

        //find console
        List<ConsoleViewModel> consoleFromService = service.findConsoleByManufacturer(consoleView.getManufacturer());
        assertEquals(1,consoleFromService.size());

    }

    @Test
    public void saveFindGame() {
        GameViewModel gameView = new GameViewModel();
        gameView.setTitle("NBA 2K");
        gameView.setEsrb_rating("E");
        gameView.setDescription("everyone");
        gameView.setPrice(new BigDecimal("59.99"));
        gameView.setStudio("2K Studios");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        //get game
        GameViewModel game2= service.findGame(gameView.getGame_id());
        assertEquals(gameView,game2);

    }



    @Test
    public void findGameByStudio() {
        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(1);
        gameView.setTitle("NBA 2K");
        gameView.setEsrb_rating("E");
        gameView.setDescription("everyone");
        gameView.setPrice(new BigDecimal("59.99"));
        gameView.setStudio("2K Studios");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByStudio(gameView.getStudio());
        assertEquals(1,gameFromService.size());

    }

    @Test
    public void findGameByErsb_Rating() {
        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(1);
        gameView.setTitle("NBA 2K");
        gameView.setEsrb_rating("E");
        gameView.setDescription("everyone");
        gameView.setPrice(new BigDecimal("59.99"));
        gameView.setStudio("2K Studios");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByEsrbRating(gameView.getEsrb_rating());
        assertEquals(1,gameFromService.size());
    }

    @Test
    public void findGameByTitle() {
        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(1);
        gameView.setTitle("NBA 2K");
        gameView.setEsrb_rating("E");
        gameView.setDescription("everyone");
        gameView.setPrice(new BigDecimal("59.99"));
        gameView.setStudio("2K Studios");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByTitle(gameView.getTitle());
        assertEquals(1,gameFromService.size());
    }

    @Test
    public void saveFindTShirt() {
        TShirtViewModel tShirtView = new TShirtViewModel();

        tShirtView.setSize("L");
        tShirtView.setColor("Black");
        tShirtView.setDescription("A nice shirt");
        tShirtView.setPrice(new BigDecimal("34.00"));
        tShirtView.setQuantity(3);
        tShirtView = service.saveTShirt(tShirtView);

        TShirtViewModel tShirtVM = service.findTShirt(tShirtView.getT_shirt_id());
        assertEquals(tShirtView,tShirtVM);

    }

    @Test
    public void findTShirtByColor() {
        TShirtViewModel tShirtView = new TShirtViewModel();
        tShirtView.setT_shirt_id(1);
        tShirtView.setSize("L");
        tShirtView.setColor("Black");
        tShirtView.setDescription("A nice shirt");
        tShirtView.setPrice(new BigDecimal("34.00"));
        tShirtView.setQuantity(3);
        tShirtView = service.saveTShirt(tShirtView);

        List<TShirtViewModel> tShirtFromService = service.findTShirtByColor(tShirtView.getColor());
        assertEquals(1,tShirtFromService.size());
    }


    @Test
    public void findTShirtBySize() {
        TShirtViewModel tShirtView = new TShirtViewModel();
        tShirtView.setT_shirt_id(1);
        tShirtView.setSize("L");
        tShirtView.setColor("Black");
        tShirtView.setDescription("A nice shirt");
        tShirtView.setPrice(new BigDecimal("34.00"));
        tShirtView.setQuantity(3);
        tShirtView = service.saveTShirt(tShirtView);

        List<TShirtViewModel> tShirtFromService = service.findTShirtBySize(tShirtView.getSize());
        assertEquals(1,tShirtFromService.size());
    }

    @Test
    public void saveFindInvoice() {

        InvoiceViewModel invoiceView = new InvoiceViewModel();

        invoiceView.setName("invoice");
        invoiceView.setStreet("123 Main St");
        invoiceView.setCity("Los Angeles");
        invoiceView.setState("CA");
        invoiceView.setZipcode("72194");
        invoiceView.setItem_type("itemType");
        invoiceView.setItem_id(2);
        invoiceView.setUnit_price(new BigDecimal("3.25"));
        invoiceView.setQuantity(4);
        invoiceView.setSubtotal(new BigDecimal("35.50"));
        invoiceView.setTax(new BigDecimal("2.30"));
        invoiceView.setProcessing_fee(new BigDecimal("4.00"));
        invoiceView.setTotal(new BigDecimal("62.50"));

        invoiceView = service.saveInvoice(invoiceView);

        InvoiceViewModel invoiceFromService = service.findInvoice(invoiceView.getInvoice_id());
        assertEquals(invoiceView,invoiceFromService);
    }
}