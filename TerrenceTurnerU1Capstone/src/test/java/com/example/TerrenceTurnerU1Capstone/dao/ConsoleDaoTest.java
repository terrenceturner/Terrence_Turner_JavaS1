package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    // Properties
    @Autowired
    protected ConsoleDao consoleDao;


    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream()
                .forEach(console -> consoleDao.deleteConsole(console.getConsole_id()));
    }

    @Test
    public void addGetDeleteConsole() {

        Console console = new Console();
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);

        //add
        console = consoleDao.addConsole(console);

        //get
        Console console1 = consoleDao.getConsole(console.getConsole_id());

        assertEquals(console,console1);

        //delete
        consoleDao.deleteConsole(console.getConsole_id());

        Console console2 = consoleDao.getConsole((console.getConsole_id()));

        assertNull(console2);

    }



    @Test
    public void getAllConsole() {
        Console console = new Console();
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console = consoleDao.addConsole(console);

        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console = consoleDao.addConsole(console);

        List<Console> consoleList = consoleDao.getAllConsoles();
        assertEquals(2,consoleList.size());
    }

    @Test
    public void updateConsole() {
        Console console = new Console();

        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);

        console = consoleDao.addConsole(console);

        console.setModel("SSX123");
        console.setMemory_amount("64GB");
        consoleDao.updateConsole(console);
        Console console1 = consoleDao.getConsole(console.getConsole_id());
        assertEquals(console,console1);

    }


    @Test
    public void getConsoleByManufacturer() {

        Console console = new Console();
        console.setModel("X123");
        console.setManufacturer("microsoft");
        console.setMemory_amount("16GB");
        console.setProcessor("AMD");
        console.setPrice(new BigDecimal("450.00"));
        console.setQuantity(2);
        console = consoleDao.addConsole(console);

        List<Console> consolesList = consoleDao.getConsoleByManufacturer(console.getManufacturer());

        assertEquals(1,consolesList.size());

    }

}