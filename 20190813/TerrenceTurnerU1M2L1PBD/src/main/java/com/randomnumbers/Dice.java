package com.randomnumbers;

import java.util.Random;

public class Dice {

    public static int sum(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println("HERE COMES THE DICE!\n");

        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        System.out.println("Roll #1 is: " + dice1);
        System.out.println("Roll #2 is: " + dice2);
        System.out.println("The total is " + sum(dice1, dice2) + "!");





    }


}
