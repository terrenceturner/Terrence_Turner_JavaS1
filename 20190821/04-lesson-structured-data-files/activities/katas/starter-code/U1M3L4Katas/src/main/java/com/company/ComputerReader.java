package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ComputerReader {


    public static void main(String[] args) {

        try {
            List<Computers> computers = new CsvToBeanBuilder<Computers>( new FileReader("/Users/terrenceturner/Desktop/Terrence_Turner_JavaS1/20190821/04-lesson-structured-data-files/activities/katas/starter-code/U1M3L4Katas/computers.csv"))
                    .withType(Computers.class).build().parse();


            for (Computers computer: computers) {
                System.out.println("===============");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());
            }




        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }




    }


}
