package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTest {

    @Autowired
    private SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void GetSalesTaxRate() {

        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate("CA");
        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate,salesTaxRate1);

    }
}