package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {

    public static void main(String[] args) {

        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


        try {


            ObjectMapper mapper = new ObjectMapper();

            String jsonCarList = mapper.writeValueAsString(carList);
            System.out.println(jsonCarList);

           writer = new PrintWriter(new FileWriter("car.json"));

           writer.println(jsonCarList);
           writer.flush();
           writer.close();



            for (Car cars: carList){
                System.out.println(cars.getMake());
                System.out.println(cars.getModel());
                System.out.println(cars.getColor());
                System.out.println(cars.getYear());
            }


        } catch (JsonProcessingException e){
            System.out.println("ERROR: Trouble converting object to JSON string.");
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }



    }


}
