package com.randomnumbers;

import java.util.Random;

public class FortuneCookie {

    public static void main(String[] args) {


        Random random = new Random();
        int lottoNumbers1 = random.nextInt(54) + 1;
        int lottoNumbers2 = random.nextInt(54) + 1;
        int lottoNumbers3 = random.nextInt(54) + 1;
        int lottoNumbers4 = random.nextInt(54) + 1;
        int lottoNumbers5 = random.nextInt(54) + 1;
        int lottoNumbers6 = random.nextInt(54) + 1;

        //How fortune is picked
        int fortuneNumber = random.nextInt(6) + 1;
        String fortune = "";


        //Determines fortune
        if (fortuneNumber == 1){
            fortune = "Stick with your wife.";
        } else if (fortuneNumber == 2){
            fortune = "You will be rich.";
        } else if (fortuneNumber == 3){
            fortune = "Sorry, your life sucks.";
        } else if (fortuneNumber == 4){
            fortune = "Today is your lucky day.";
        } else if (fortuneNumber == 5){
            fortune = "Stay inside.";
        } else if (fortuneNumber == 6){
            fortune = "You are awesome.";
        }

        System.out.println("Fortune cookie says: " + fortune);
        System.out.println( "\t" + lottoNumbers1 + " - " + lottoNumbers2 + " - " + lottoNumbers3 + " - " + lottoNumbers4 +
                " - " + lottoNumbers5 + " - " + lottoNumbers6 );



    }

}
