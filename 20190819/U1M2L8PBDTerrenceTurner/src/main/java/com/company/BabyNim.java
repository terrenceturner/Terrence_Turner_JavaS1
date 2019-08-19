package com.company;

import java.util.Scanner;

public class BabyNim {

    //method
    public static int subtract(int a, int b){
        return a - b;
    }


    public static void main(String[] args) {

        int pile1 = 3;
        int pile2 = 3;
        int pile3 = 3;



        while (pile1 > 0 || pile2 > 0 || pile3 > 0){

            System.out.println("A: " + pile1 + "\tB: "+ pile2 + "\tC: " + pile3 + "\n");

            Scanner scanner = new Scanner(System.in);



            System.out.println("Choose a pile: ");

            String userPile = scanner.nextLine().toUpperCase();

            System.out.println("How many to remove from pile " + userPile + ": ");
            String userPick = scanner.nextLine();
            int userNum = Integer.parseInt(userPick);


            switch (userPile){
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


        }

        System.out.println("A: " + pile1 + "\tB: "+ pile2 + "\tC: " + pile3 + "\n");

        System.out.println("All piles are empty. Good job!");



    }


}
