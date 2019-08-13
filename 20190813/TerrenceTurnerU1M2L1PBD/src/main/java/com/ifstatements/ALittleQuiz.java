package com.ifstatements;

import java.util.Scanner;

public class ALittleQuiz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready for a quiz?");
        String userInput = scanner.nextLine();
        System.out.println("Okay, here it comes!\n");

        int counter = 0;

        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("\t 1) Melbourne");
        System.out.println("\t 2) Anchorage");
        System.out.println("\t 3) Juneau");
        String userAnswer = scanner.nextLine();
        int userAnswerQ1 = Integer.parseInt(userAnswer);

        if (userAnswerQ1 == 1){
            System.out.println("Sorry, wrong answer\n");
        } else if (userAnswerQ1 == 2){
            System.out.println("Sorry, wrong answer\n");
        } else if (userAnswerQ1 == 3){
            System.out.println("That's right\n");
            counter++;
        } else {
            System.out.println("Invalid answer.\n");
        }


        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        System.out.println("\t 1) yes");
        System.out.println("\t 2) no");
        String userGiven = scanner.nextLine();
        int userAnswerQ2 = Integer.parseInt(userGiven);

        if (userAnswerQ2 == 1){
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.\n");
        } else if (userAnswerQ2 == 2){
            System.out.println("That's right!\n");
            counter++;
        } else {
            System.out.println("Invalid answer\n");
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("\t 1) 5");
        System.out.println("\t 2) 11");
        System.out.println("\t 3) 15/3");
        String userNumber = scanner.nextLine();
        int userAnswerQ3 = Integer.parseInt(userNumber);

        if (userAnswerQ3 == 1){
            System.out.println("Sorry, wrong answer\n");
        } else if (userAnswerQ3 == 2){
            System.out.println("That's correct!\n");
            counter++;
        } else {
            System.out.println("Invalid answer\n");
        }


        System.out.println("Overall, you got " + counter + " out of 3 correct.");
        System.out.println("Thanks for playing!");

    }

}
