package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int age = 19;

        if (age < 18){
            System.out.println("You cannot vote yet! \n");
        }

        if (age < 18){
            System.out.println("You cannot vote yet! \n");
        } else {
            System.out.println("You are old enough to vote! \n");
        }


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose one of the following menu choices \n");
        System.out.println("S for Sales department");
        System.out.println("C for Customer Support");
        System.out.println("E for Engineering");


        String userChoice = scanner.nextLine().toUpperCase();


        switch (userChoice){
            case "S":
//            case "s":
                System.out.println("Welcome to the Sales Department. \n");
                break;
            case "C":
//            case "c":
                System.out.println("Welcome to Customer Support.\n");
                break;
            case "E":
//            case "e":
                System.out.println("Welcome to Engineering. \n");
                break;
            default:
                System.out.println("You have entered an invalid choice. \n");
        }

        // Get input from the user
//        System.out.println("Please enter a number between 1 and 7 inclusive: ");
//        String userInput = scanner.nextLine();

        //Convert the user input to a number
//        int userDay = Integer.parseInt(userInput);

        /* compare userDay to the numbers between 1 and 7 and print out
        the correct day.
        Note that the week 1 starts on monday
         */

//        if (userDay == 1){
//            System.out.println("Monday");
//        } else if (userDay == 2) {
//            System.out.println("Tuesday");
//        } else if (userDay == 3){
//            System.out.println("Wednesday");
//        } else if (userDay == 4){
//            System.out.println("Thursday");
//        } else if (userDay == 5) {
//            System.out.println("Friday");
//        } else if (userDay == 6){
//            System.out.println("Saturday");
//        } else if (userDay == 7){
//            System.out.println("Sunday");
//        } else {
//            System.out.println("You entered an invalid number!");
//        }

        // Convert user day to day of the week
//        switch (userDay){
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("You entered an invalid number!");
//
//        }

//        System.out.println("Would like to print some words to the screen? (y for yes)");
//        String userInput = scanner.nextLine();
//
//        //enter the whole loop if the user typed in 'y'
//        // cannot do (userInput == "y"
//        while (userInput.equals("y")){
//            System.out.println("Type a word you want to print to the screen: ");
//            String word = scanner.nextLine();
//            System.out.println(word);
//
//            System.out.println("Would you like to try again? (y for yes)");
//            userInput = scanner.nextLine();
//        }
//
//        System.out.println("Ok - see you later!");
//
//
//        int userInt;
//        do {
//            System.out.println("Enter a number between 1 and 10");
//            userInput = scanner.nextLine();
//            userInt = Integer.parseInt(userInput);
//
//        } while (userInt < 1 || userInt > 10);
//
//        System.out.println("Great! You chose " + userInput);





        //For loop
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(i);
//        }


        //Random Generator
        Random randomGenerator = new Random();

        int randomInt = randomGenerator.nextInt();
        System.out.println(randomInt);

        for ( int i = 0; i < 20; i++){
            randomInt = randomGenerator.nextInt(4);
            System.out.println(randomInt);
        }

        System.out.println("=======================");

        int rollValue = randomGenerator.nextInt(6) + 1;
        System.out.println(rollValue);

        for (int i = 0; i < 10; i++) {
            rollValue = randomGenerator.nextInt(6) + 1;
            System.out.println(rollValue);
        }

    }


}
