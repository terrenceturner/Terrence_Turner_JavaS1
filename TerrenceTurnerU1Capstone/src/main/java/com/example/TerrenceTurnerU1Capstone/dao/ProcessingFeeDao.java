package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.ProcessingFee;

public interface ProcessingFeeDao {

    ProcessingFee getProcessingFee(String product_type);
}
