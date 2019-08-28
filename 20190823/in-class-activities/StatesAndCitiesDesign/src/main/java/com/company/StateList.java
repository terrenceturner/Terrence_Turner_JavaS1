package com.company;

import java.util.Scanner;

public class StateList {

    //Add State and city
    public void addState(){

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Let's add a state...");
            System.out.println("Enter a state name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the state's population.");
            String statePop = scanner.nextLine();
            int statePopulation = Integer.parseInt(statePop);

            System.out.println("Enter the name of the city.");
            String city = scanner.nextLine();

            System.out.println("Enter the city's population.");
            String cityPop = scanner.nextLine();
            int cityPopulation = Integer.parseInt(cityPop);

            System.out.println("Is the city the capital of the state?");
            boolean capitalCity = scanner.nextBoolean();



        }


    }

}
