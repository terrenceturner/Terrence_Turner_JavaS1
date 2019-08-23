package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) {


        try {


            //read and store data in a list
            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> televisionsList = mapper.readValue(new File("televisions.json"),
                    new TypeReference<List<Televisions>>() {});

            //find and print screen sizes greater than 60
            int screenSize = 60;
            televisionsList.stream().filter(television->television.getScreenSize() > screenSize).forEach(television-> {
                System.out.println(television.toString());
            });

            //Group into map by brand
            Map<String, List<Televisions>> groupedTelevisions = televisionsList.stream().collect(Collectors.groupingBy(b->b.getBrand()));
            Set<String> keys = groupedTelevisions.keySet();

            for (String key:keys){
                System.out.println(key);
            }

            //find and print the average screen size
            double avgScreenSize = televisionsList.stream().mapToInt(b->b.getScreenSize()).average().getAsDouble();
            System.out.println("Average screen size is " + avgScreenSize);

            //find largest screen size
            int largestScreenSize = televisionsList.stream().mapToInt(bike->bike.getScreenSize()).max().getAsInt();
            System.out.println("Largest screen size is " + largestScreenSize);





        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
