package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("Welcome to Hi-Low!");

        System.out.println("What is your name?");
        String userName = scanner.nextLine();
        System.out.println("OK, " + userName + ", here are the rules:");

        System.out.println("The computer will come up with a number between 1 and 100 (inclusive).");
        System.out.println("The user will be prompted to guess the number.");
        System.out.println("If the user guesses the number correctly, the program displays:");
        System.out.println("\t Congratulations, " + userName + "! You win!");
        System.out.println("\t It took you [number of guesses] guesses to find my number!");
        System.out.println("If the user does not guess the number correctly, the program will display “Too low!” " +
                "if the guess is too low and “Too high!” if the guess is too high, and then will prompt the user " +
                "for another guess.  This goes on until the number is guessed correctly.");

        int randomNumber = randomGenerator.nextInt(101) + 1;
        System.out.println(randomNumber);



        String userInput;
        int userInt;
        int count = 0;

        do {
            System.out.println("Guess a number between 1 and 100?");
            userInput = scanner.nextLine();
            userInt = Integer.parseInt(userInput);
            count++;

            if (userInt < randomNumber){
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.println("try again.");

        } while (userInt != randomNumber);

        System.out.println("Congratulations, " + userName + "! You Win!");
        System.out.println("It took you " + count + " guesses to find my number!");










    }
}
