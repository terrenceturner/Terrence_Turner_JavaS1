package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    private ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void GetProcessingFee() {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee("consoles");
        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProduct_type());

        assertEquals(processingFee,processingFee1);
    }
}