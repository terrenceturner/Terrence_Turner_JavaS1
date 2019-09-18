package com.example.TerrenceTurnerU1Capstone.dao;

import com.example.TerrenceTurnerU1Capstone.dto.Console;

import java.util.List;

public interface ConsoleDao {

    Console getConsole(int console_id);

    List<Console> getAllConsoles();

    Console addConsole(Console console);

    void updateConsole(Console console);

    void deleteConsole(int console_id);

    List<Console> getConsoleByManufacturer (String manufacturer);
}
