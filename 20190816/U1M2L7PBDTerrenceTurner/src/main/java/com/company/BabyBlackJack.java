package com.company;

import java.util.Random;

public class BabyBlackJack {



    public static void main(String[] args) {


        Random randomCards = new Random();

        System.out.println("Baby Blackjack!\n");

        int playerCard1 = randomCards.nextInt(10) + 1;
        int playerCard2 = randomCards.nextInt(10) + 1;
        int dealerCard1 = randomCards.nextInt(10) + 1;
        int dealerCard2 = randomCards.nextInt(10) + 1;


        int playerTotal = playerCard1 + playerCard2;
        int dealerTotal = dealerCard1 + dealerCard2;

        System.out.println("You drew " + playerCard1 + " and " + playerCard2);
        System.out.println("Your total is " + playerTotal + "\n");

        System.out.println("The dealer has " + dealerCard1 + " and " + dealerCard2);
        System.out.println("Your total is " + dealerTotal + "\n");

        if (playerTotal > dealerTotal ){
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose!");
        }


    }




}
