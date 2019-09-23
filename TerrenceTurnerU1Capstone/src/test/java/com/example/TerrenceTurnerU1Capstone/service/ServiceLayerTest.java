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
    TShirtDao tshirtDao;
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxDaoMock();

        service = new ServiceLayer(consoleDao,gameDao,invoiceDao,tshirtDao,processingFeeDao,salesTaxRateDao);
    }
    private void setUpConsoleDaoMock(){
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsole_id(2);
        console.setModel("A");
        console.setManufacturer("b");
        console.setMemory_amount("4gb");
        console.setProcessor("gui");
        console.setPrice(BigDecimal.valueOf(23.00));
        console.setQuantity(2);

        Console console2 = new Console();
        console2.setModel("A");
        console2.setManufacturer("b");
        console2.setMemory_amount("4gb");
        console2.setProcessor("gui");
        console2.setPrice(BigDecimal.valueOf(23.00));
        console2.setQuantity(2);

        Console updatedConsole = new Console();
        updatedConsole.setConsole_id(3);
        updatedConsole.setModel("A");
        updatedConsole.setManufacturer("b");
        updatedConsole.setMemory_amount("4gb");
        updatedConsole.setProcessor("gui");
        updatedConsole.setPrice(BigDecimal.valueOf(23.00));
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
        game.setTitle("wii");
        game.setEsrb_rating("T");
        game.setDescription("jdhewio");
        game.setPrice(BigDecimal.valueOf(45.00));
        game.setStudio("samsung");
        game.setQuantity(2);

        Game game2 = new Game();
        game2.setTitle("wii");
        game2.setEsrb_rating("T");
        game2.setDescription("jdhewio");
        game2.setPrice(BigDecimal.valueOf(45.00));
        game2.setStudio("samsung");
        game2.setQuantity(2);

        Game updatedGame = new Game();
        updatedGame.setTitle("T");
        updatedGame.setEsrb_rating("u");
        updatedGame.setDescription("hswi");
        updatedGame.setPrice(BigDecimal.valueOf(45.00));
        updatedGame.setStudio("samsung");
        updatedGame.setQuantity(2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(updatedGame).when(gameDao).updateGame(updatedGame);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGameByEsrbRating("T");
        doReturn(gameList).when(gameDao).getGameByTitle("wii");
        doReturn(gameList).when(gameDao).getGameByStudio("samsung");

    }
    private void setUpTShirtDaoMock() {

        tshirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt tshirt = new TShirt();
        tshirt.setT_shirt_id(1);
        tshirt.setSize("M");
        tshirt.setColor("Black");
        tshirt.setDescription("hdiwh");
        tshirt.setPrice(BigDecimal.valueOf(67.00));
        tshirt.setQuantity(6);

        TShirt tshirt2 = new TShirt();
        tshirt2.setSize("M");
        tshirt2.setColor("Black");
        tshirt2.setDescription("hdiwh");
        tshirt2.setPrice(BigDecimal.valueOf(67.00));
        tshirt2.setQuantity(6);

        TShirt updatedTShirt = new TShirt();
        updatedTShirt.setT_shirt_id(1);
        updatedTShirt.setSize("L");
        updatedTShirt.setColor("White");
        updatedTShirt.setDescription("hdiwh");
        updatedTShirt.setPrice(BigDecimal.valueOf(23.00));
        updatedTShirt.setQuantity(6);

        List<TShirt> tshirtList = new ArrayList<>();
        tshirtList.add(tshirt);

        doReturn(tshirt).when(tshirtDao).addTShirt(tshirt2);
        doReturn(tshirt).when(tshirtDao).getTShirt(1);
        doReturn(updatedTShirt).when(tshirtDao).updateTShirt(updatedTShirt);
        doReturn(tshirtList).when(tshirtDao).getAllTShirts();
        doReturn(tshirtList).when(tshirtDao).getTShirtBySize(("M"));
        doReturn(tshirtList).when(tshirtDao).getTShirtByColor("Black");
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
        invoice.setName("yasser");
        invoice.setStreet("xyz street");
        invoice.setCity("new york");
        invoice.setState("NY");
        invoice.setZipcode("93829");
        invoice.setItem_type("u");
        invoice.setItem_id(3);
        invoice.setUnit_price(BigDecimal.valueOf(3.00));
        invoice.setQuantity(3);
        invoice.setSubtotal(BigDecimal.valueOf(9.00));
        invoice.setTax(BigDecimal.valueOf(76.00));
        invoice.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice.setTotal(BigDecimal.valueOf(86.49));

        Invoice invoice2 = new Invoice();

        invoice2.setName("yasser");
        invoice2.setStreet("xyz street");
        invoice2.setCity("new york");
        invoice2.setState("NY");
        invoice2.setZipcode("93829");
        invoice2.setItem_type("u");
        invoice2.setItem_id(3);
        invoice2.setUnit_price(BigDecimal.valueOf(3.00));
        invoice2.setQuantity(3);
        invoice2.setSubtotal(BigDecimal.valueOf(9.00));
        invoice2.setTax(BigDecimal.valueOf(76.00));
        invoice2.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoice2.setTotal(BigDecimal.valueOf(86.49));


        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(2);
        doReturn(processingFee).when(processingFeeDao).getProcessingFee(anyString());
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate(anyString());
    }

    private void setUpSalesTaxDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NC");
        salesTaxRate.setRate(new BigDecimal(".05"));

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NC");
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
        consoleView.setModel("A");
        consoleView.setManufacturer("b");
        consoleView.setMemory_amount("4gb");
        consoleView.setProcessor("gui");
        consoleView.setPrice(BigDecimal.valueOf(23.00));
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
        consoleView.setModel("A");
        consoleView.setManufacturer("b");
        consoleView.setMemory_amount("4gb");
        consoleView.setProcessor("gui");
        consoleView.setPrice(BigDecimal.valueOf(23.00));
        consoleView.setQuantity(2);
        consoleView = service.saveConsole(consoleView);

        //find console
        List<ConsoleViewModel> consoleFromService = service.findConsoleByManufacturer(consoleView.getManufacturer());
        assertEquals(1,consoleFromService.size());

    }

    @Test
    public void saveFindGame() {
        GameViewModel gameView = new GameViewModel();
        gameView.setTitle("wii");
        gameView.setErsb_rating("T");
        gameView.setDescription("jdhewio");
        gameView.setPrice(BigDecimal.valueOf(45.00));
        gameView.setStudio("samsung");
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
        gameView.setTitle("wii");
        gameView.setErsb_rating("T");
        gameView.setDescription("jdhewio");
        gameView.setPrice(BigDecimal.valueOf(45.00));
        gameView.setStudio("samsung");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByStudio(gameView.getStudio());
        assertEquals(1,gameFromService.size());

    }

    @Test
    public void findGameByErsb_Rating() {
        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(1);
        gameView.setTitle("wii");
        gameView.setErsb_rating("T");
        gameView.setDescription("jdhewio");
        gameView.setPrice(BigDecimal.valueOf(45.00));
        gameView.setStudio("samsung");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByEsrbRating(gameView.getErsb_rating());
        assertEquals(1,gameFromService.size());
    }

    @Test
    public void findGameByTitle() {
        GameViewModel gameView = new GameViewModel();
        gameView.setGame_id(1);
        gameView.setTitle("wii");
        gameView.setErsb_rating("T");
        gameView.setDescription("jdhewio");
        gameView.setPrice(BigDecimal.valueOf(45.00));
        gameView.setStudio("samsung");
        gameView.setQuantity(2);
        gameView = service.saveGame(gameView);
        List<GameViewModel> gameFromService = service.findGameByTitle(gameView.getTitle());
        assertEquals(1,gameFromService.size());
    }

    @Test
    public void saveFindTShirt() {
        TShirtViewModel tShirtView = new TShirtViewModel();

        tShirtView.setSize("M");
        tShirtView.setColor("Black");
        tShirtView.setDescription("hdiwh");
        tShirtView.setPrice(BigDecimal.valueOf(67.00));
        tShirtView.setQuantity(6);
        tShirtView = service.saveTShirt(tShirtView);

        TShirtViewModel tshirtVM = service.findTShirt(tShirtView.getT_shirt_id());
        assertEquals(tShirtView,tshirtVM);

    }

    @Test
    public void findTShirtByColor() {
        TShirtViewModel tShirtView = new TShirtViewModel();
        tShirtView.setT_shirt_id(1);
        tShirtView.setSize("M");
        tShirtView.setColor("Black");
        tShirtView.setDescription("hdiwh");
        tShirtView.setPrice(BigDecimal.valueOf(67.00));
        tShirtView.setQuantity(6);
        tShirtView = service.saveTShirt(tShirtView);

        List<TShirtViewModel> tshirtFromService = service.findTShirtByColor(tShirtView.getColor());
        assertEquals(1,tshirtFromService.size());
    }


    @Test
    public void findTShirtBySize() {
        TShirtViewModel tShirtView = new TShirtViewModel();
        tShirtView.setT_shirt_id(1);
        tShirtView.setSize("M");
        tShirtView.setColor("Black");
        tShirtView.setDescription("hdiwh");
        tShirtView.setPrice(BigDecimal.valueOf(67.00));
        tShirtView.setQuantity(6);
        tShirtView = service.saveTShirt(tShirtView);

        List<TShirtViewModel> tshirtFromService = service.findTShirtBySize(tShirtView.getSize());
        assertEquals(1,tshirtFromService.size());
    }

    @Test
    public void saveFindInvoice() {

        InvoiceViewModel invoiceView = new InvoiceViewModel();

        invoiceView.setName("yasser");
        invoiceView.setStreet("xyz street");
        invoiceView.setCity("new york");
        invoiceView.setState("NY");
        invoiceView.setZipcode("93829");
        invoiceView.setItem_type("u");
        invoiceView.setItem_id(3);
        invoiceView.setUnit_price(BigDecimal.valueOf(3.00));
        invoiceView.setQuantity(3);
        invoiceView.setSubtotal(BigDecimal.valueOf(9.00));
        invoiceView.setTax(BigDecimal.valueOf(76.00));
        invoiceView.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceView.setTotal(BigDecimal.valueOf(86.49));

        invoiceView = service.saveInvoice(invoiceView);

        InvoiceViewModel invoiceFromService = service.findInvoice(invoiceView.getInvoice_id());
        assertEquals(invoiceView,invoiceFromService);
    }
}