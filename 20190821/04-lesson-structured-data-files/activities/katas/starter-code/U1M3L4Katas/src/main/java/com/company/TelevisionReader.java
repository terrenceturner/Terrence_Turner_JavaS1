package com.company;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {

    public static void main(String[] args) {

        try {


            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> televisions = mapper.readValue(new File("/Users/terrenceturner/Desktop/Terrence_Turner_JavaS1/20190821/04-lesson-structured-data-files/activities/katas/starter-code/U1M3L4Katas/televisions.json"),
                    new TypeReference<List<Televisions>>() {});

            for (Televisions television : televisions) {
                System.out.println("===============");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());

            }

        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }



    }
}
