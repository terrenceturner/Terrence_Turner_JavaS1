package com.randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {

    public static void main(String[] args) {

        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomInt = randomGenerator.nextInt(10);

        System.out.println("I'm thinking of a number between 1 and 10");
        int userGuess = scanner.nextInt();

        if (userGuess == randomInt){
            System.out.println("That's right! My secret number was " + randomInt);
        } else {
            System.out.println("Your guess: " + userGuess + "\n");
            System.out.println("Sorry, but I was really thinking of " + randomInt);
        }



    }






}
