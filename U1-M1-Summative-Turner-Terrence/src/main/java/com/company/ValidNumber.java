package com.company;

import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 10: ");
        String userInput = scanner.nextLine();
        int userNum = Integer.parseInt(userInput);


//        while ((userNum <= 1) || (userNum >= 10)){
//            System.out.println("You must enter a number between 1 and 10, please try again.");
//            userInput = scanner.nextLine();
//            userNum = Integer.parseInt(userInput);
//
//        }




        do {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = scanner.nextLine();
            userNum = Integer.parseInt(userInput);
        } while ((userNum <= 1) || (userNum >= 10));

        System.out.println("Awesome! You entered " + userNum);


    }
}
