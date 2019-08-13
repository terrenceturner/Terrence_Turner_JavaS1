package com.com.whileloops;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {

    public static void main(String[] args) {

        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomInt = randomGenerator.nextInt(10) + 1;

        System.out.println("I'm thinking of a number between 1 and 10");
        int userGuess = scanner.nextInt();


        while (userGuess != randomInt){
            System.out.println("That is incorrect. Guess again.");
            userGuess = scanner.nextInt();

        }

        if (userGuess == randomInt){
            System.out.println("That's right. You're a good guesser.");
        }



    }


}
