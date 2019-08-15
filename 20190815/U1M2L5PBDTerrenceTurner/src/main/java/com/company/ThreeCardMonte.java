package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {


        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.\n");

        System.out.println("Which one is the ace?\n");

        System.out.println("\t\t## \t## \t##");
        System.out.println("\t\t## \t## \t##");
        System.out.println("\t\t1 \t2 \t3");

        Scanner scanner = new Scanner(System.in);
        Random randomCard = new Random();


        int aceAnswer = randomCard.nextInt(3) + 1;
//        System.out.println(aceAnswer);

        String userAnswer = scanner.nextLine();
        int userNum = Integer.parseInt(userAnswer);


        if (userNum == aceAnswer){
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");

            switch (aceAnswer){
                case 1:
                    System.out.println("\t\tAA \t## \t##");
                    System.out.println("\t\tAA \t## \t##");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                case 2:
                    System.out.println("\t\t## \tAA \t##");
                    System.out.println("\t\t## \tAA \t##");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                case 3:
                    System.out.println("\t\t## \t## \tAA");
                    System.out.println("\t\t## \t## \tAA");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                default:
            }

        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + aceAnswer + ".\n");

            switch (aceAnswer){
                case 1:
                    System.out.println("\t\tAA \t## \t##");
                    System.out.println("\t\tAA \t## \t##");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                case 2:
                    System.out.println("\t\t## \tAA \t##");
                    System.out.println("\t\t## \tAA \t##");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                case 3:
                    System.out.println("\t\t## \t## \tAA");
                    System.out.println("\t\t## \t## \tAA");
                    System.out.println("\t\t1 \t2 \t3");
                    break;
                default:
            }
        }


    }




}
