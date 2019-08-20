package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class City {

    private String name;
    private long population;

    public City(String name, long population) {
        this.name = name;
        this.population = population;
    }



    public static void main(String[] args) {

        City newYork = new City("New York", 8654321l );
        City losAngeles = new City("Los Angeles", 4563218l);
        City chicago = new City("Chicago", 2716520l );
        City denver = new City("Denver", 704621l);
        City desMoines = new City("Des Moines", 217521l );
        City atlanta = new City("Atlanta", 486213l);


        //Map
        Map<String, City> state = new HashMap<>();

        state.put("New York", newYork);
        state.put("California", losAngeles);
        state.put("Illinois", chicago);
        state.put("Colorado", denver);
        state.put("Georgia", atlanta);


        //Loop through map printing city, state, population
        Set<Map.Entry<String, City>> myEntries = state.entrySet();
        for (Map.Entry<String, City> entry:myEntries){
            System.out.println(entry.getValue().name + ", " + entry.getKey() + " " + entry.getValue().population);
        }


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the minimum population: ");
        String userInput = scanner.nextLine();
        int userPop = Integer.parseInt(userInput);

        //Loop through map but only printing city and states that are > user given population
        for (Map.Entry<String, City> entry:myEntries){
            if (userPop < entry.getValue().population){
                System.out.println(entry.getValue().name + ", " + entry.getKey());
            }
        }







    }


}
