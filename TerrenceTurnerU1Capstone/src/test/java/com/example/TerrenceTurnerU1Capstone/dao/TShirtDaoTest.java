package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.TShirt;
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
public class TShirtDaoTest {

    @Autowired
    private TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.stream()
                .forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getT_shirt_id()));
    }

    @Test
    public void addGetDeleteTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        //add
        tShirt = tShirtDao.addTShirt(tShirt);
        //get
        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.getT_shirt_id());
        assertEquals(tShirt,tShirt1);
        // delete
        tShirtDao.deleteTShirt(tShirt.getT_shirt_id());

        TShirt tShirt2 = tShirtDao.getTShirt((tShirt.getT_shirt_id()));

        assertNull(tShirt2);

    }

    @Test
    public void getAllTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        //add
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        //add
        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        assertEquals(2,tShirtList.size());

    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        //add
        tShirt = tShirtDao.addTShirt(tShirt);
        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        //add

        tShirtDao.updateTShirt(tShirt);
        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.getT_shirt_id());
        assertEquals(tShirt1,tShirt);

    }

    @Test
    public void getTShirtByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        tShirt = tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getTShirtByColor((tShirt.getColor()));
        assertEquals(1,tShirtList.size());

    }

    @Test
    public void getTShirtBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("L");
        tShirt.setColor("Black");
        tShirt.setDescription("A nice shirt");
        tShirt.setPrice(new BigDecimal("34.00"));
        tShirt.setQuantity(3);
        tShirt = tShirtDao.addTShirt(tShirt);
        List<TShirt> tShirtList = tShirtDao.getTShirtBySize((tShirt.getSize()));
        assertEquals(1,tShirtList.size());
    }
}