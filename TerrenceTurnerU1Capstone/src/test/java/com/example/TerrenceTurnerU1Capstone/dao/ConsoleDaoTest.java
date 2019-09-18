package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ConsoleDaoTest {

    // Properties
    @Autowired
    protected ConsoleDao consoledao;

    @Autowired
    protected GameDao gamedao;

    @Autowired
    protected InvoiceDao invoiceDao;

    @Autowired
    protected TShirtDao tShirtDao;

    @Autowired
    protected ProcessingFeeDao processingFeeDao;

    @Autowired
    protected SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
        // Clean the Console database
        List<Console> consoleList = consoledao.getAllConsoles();
        consoleList.forEach(console -> consoledao.deleteConsole(console.getConsole_id()));

        // Clean the Invoice database
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoice_id()));

        // Clean the Game database
        List<Game> gameList = gamedao.getAllGames();
        gameList.forEach(game -> gamedao.deleteGame(game.getGame_id()));

        // Clean the TShirt database
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getT_shirt_id()));



    }

    @Test
    public void getAddDeleteConsole() {


    }


}