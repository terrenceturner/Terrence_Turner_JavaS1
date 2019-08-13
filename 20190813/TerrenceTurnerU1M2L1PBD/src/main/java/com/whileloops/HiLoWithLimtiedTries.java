package com.whileloops;

import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimtiedTries {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNum = random.nextInt(100) + 1;



        System.out.println("I'm thinking of a number between 1 and 100. You have 7 guesses.");
        int userGuess = scanner.nextInt();
        int guesses = 1;


        System.out.println("First guess: " + userGuess);

        while (userGuess != randomNum){

            guesses++;

            if (userGuess < randomNum){
                System.out.println("Sorry, you are too low. Try again");
            } else {
                System.out.println("Sorry, that guess is too high. Try again");
            }

            userGuess = scanner.nextInt();
            System.out.println("Guess # " + guesses + ": " + userGuess);

            if (guesses == 7){
                System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
                break;
            }

        }

        if (userGuess == randomNum){
            System.out.println("You guessed it! What are the odds?!?");
        }


    }


}
