package com.company;

import java.util.Scanner;

public class SafeSquareRoot {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number: ");
        String userAnswer = scanner.nextLine();
        double userNum = Double.parseDouble(userAnswer);


        if (userNum < 0) {


            do {


                System.out.println("You can't take the square root of a negative number, silly.");
                System.out.println("Try again");
                userNum = scanner.nextInt();



            } while (userNum < 0);

        }




        System.out.println("The square root of " + userNum + " is " + Math.sqrt(userNum));


    }



}
