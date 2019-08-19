package com.company;

import java.util.Scanner;

public class Nim {

    //method
    public static int subtract(int a, int b){
        return a - b;
    }


    public static void main(String[] args) {

        int pile1 = 3;
        int pile2 = 4;
        int pile3 = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, enter your name: ");
        String player1 = scanner.nextLine();

        System.out.println("Player 2, enter your name: ");
        String player2 = scanner.nextLine();




        while (pile1 > 0 || pile2 > 0 || pile3 > 0){

            System.out.println("A: " + pile1 + "\tB: "+ pile2 + "\tC: " + pile3 + "\n");


            //player1
            System.out.println(player1 + ", choose a pile: ");

            String userPile1 = scanner.nextLine().toUpperCase();

            System.out.println("How many to remove from pile " + userPile1 + ": ");
            String userPick = scanner.nextLine();
            int userNum = Integer.parseInt(userPick);




            switch (userPile1){
                case "A":
                    pile1 = subtract(pile1, userNum);
                    break;
                case "B":
                    pile2 = subtract(pile2, userNum);
                    break;
                case "C":
                    pile3 = subtract(pile3, userNum);
                default:
            }



            System.out.println("A: " + pile1 + "\tB: "+ pile2 + "\tC: " + pile3 + "\n");

            //player2
            System.out.println(player2 + ", choose a pile: ");
            String userPile2 = scanner.nextLine().toUpperCase();

            System.out.println("How many to remove from pile " + userPile2 + ": ");
            String userPick2 = scanner.nextLine();
            int userNum2 = Integer.parseInt(userPick2);




            switch (userPile2){
                case "A":
                    pile1 = subtract(pile1, userNum2);
                    break;
                case "B":
                    pile2 = subtract(pile2, userNum2);
                    break;
                case "C":
                    pile3 = subtract(pile3, userNum2);
                default:
            }


        }

        System.out.println("A: " + pile1 + "\tB: "+ pile2 + "\tC: " + pile3 + "\n");

        System.out.println("All piles are empty. Good job!");



    }

}
