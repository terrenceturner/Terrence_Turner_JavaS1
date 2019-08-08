package com.company;

import java.util.Random;

public class Main {


    public static void main(String[]args){

        Random randomGenerator = new Random();

        int i;
        int numSevens = 0;




        for (i = 1; i < 101; i++) {
            int dice1 = randomGenerator.nextInt(6) + 1;
            int dice2 = randomGenerator.nextInt(6) + 1;
            System.out.println(dice1);
            System.out.println(dice2);

            int sumDice = dice1 + dice2;



           if (sumDice == 7 ){
              numSevens++;
           }


        }

        System.out.println("Total number of 7: " + numSevens);





    }

}
